class Solution {
    
    static long[] pow5 = new long[21];
    
    public long solution(int n, long l, long r) {
        long answer = 0;
        
        pow5[0] = 1;
        for(int i = 1; i <= 20; i++){
            pow5[i] = pow5[i-1] * 5;
        }
        
        answer = countOnes(n, l, r);
        return answer;
    }
    
    private static long countOnes(int n, long l, long r){
        
        if(n == 0) {
            if (l <= 1 && r >= 1) return 1;
            else return 0;
        }
        
        if(n == 1) {
            // [l,r]가 [1..5] 범위를 벗어나면 0
            if(r < 1 || l > 5) return 0;
            
            // 겹치는 범위를 [1..5] 안에서 자른 뒤,
            long start = Math.max(l, 1);
            long end   = Math.min(r, 5);
            
            long count = 0;
            // 실제 "11011"에서 index=1,2,3,4,5
            // (3번 위치만 '0', 나머지는 '1')
            for(long i = start; i <= end; i++){
                if(i == 3) {
                    // 중앙만 '0'
                } else {
                    count++; 
                }
            }
            return count;
        }
        
        long blockSize = pow5[n - 1];
        long totalCount = 0;
        
        for(int blockIndex = 0; blockIndex < 5; blockIndex ++){
            long start = blockIndex * blockSize + 1;
            long end = start + blockSize - 1;
            
            if(end < l || start > r) continue;
            
            long overlapLeft = Math.max(l, start);
            long overlapRight = Math.min(r, end);
            
            long parentIndex = blockIndex + 1;
            if(isParentBitOne(n-1, parentIndex)){
                
                long newL = overlapLeft - start + 1;
                long newR = overlapRight - start + 1;
                
                totalCount += countOnes(n - 1, newL, newR);
            }
            
        }
        
        return totalCount;
        
    }
    
    private static boolean isParentBitOne(int n, long pos){
        if(n == 0) return true;
        if(n == 1) return (pos == 3) ? false : true;
        
        long blockSize = pow5[n-1];
        long blockIndex = (pos - 1) / blockSize;
        long inBlockPos = (pos - 1) % blockSize + 1;
        
        boolean parent = isParentBitOne(n - 1, blockIndex + 1);
        
        if(!parent) return false;
        else{
            long subBlockSize = blockSize / 5;
            long whichPart = (inBlockPos - 1) / subBlockSize;
            
            if(whichPart == 2) return false;
            else{
                long newPos = (inBlockPos - 1) % subBlockSize + 1;
                return isParentBitOne(n - 1, newPos);
            }
        }
        
    }
    
    
    
}