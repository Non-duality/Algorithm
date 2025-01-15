class Solution {

    // 5^n을 미리 계산해두는 배열
    static long[] pow5 = new long[21];
    
    public long solution(int n, long l, long r) {
        // pow5 배열 초기화
        pow5[0] = 1;
        for(int i = 1; i <= 20; i++){
            pow5[i] = pow5[i - 1] * 5;
        }
        
        // 구간 [l, r]에서 '1'의 개수 계산
        long answer = countOnes(n, l, r);
        return answer;
    }
    
    /**
     * 분할정복으로 "n단계 유사 칸토어 비트열"에서
     * 구간 [l, r]에 포함된 '1'의 개수를 계산하는 메서드
     */
    private static long countOnes(int n, long l, long r) {
        
        // -------------------------------------
        // 1) 기저 사례: n=0 => 문자열 "1" (길이 1)
        //    구간 [l,r]와 [1,1]이 겹치면 1개, 아니면 0개
        // -------------------------------------
        if(n == 0) {
            if (l <= 1 && r >= 1) return 1;
            else return 0;
        }
        
        // -------------------------------------
        // 2) n=1 => 문자열 "11011" (길이 5)
        //    여기서는 중앙(3번 인덱스)만 '0', 나머지는 '1'
        // -------------------------------------
        if(n == 1) {
            // [1..5] 범위와 [l, r]가 겹치지 않으면 0
            if(r < 1 || l > 5) return 0;
            
            // 겹치는 구간을 구해서, 실제 '1' 글자 수 세기
            long startIdx = Math.max(l, 1);
            long endIdx   = Math.min(r, 5);
            
            long count = 0;
            // "11011"에서 인덱스 1,2,3,4,5 (1-based)
            //   3번 자리만 '0', 나머지는 '1'
            for(long i = startIdx; i <= endIdx; i++){
                if(i == 3) {
                    // 가운데(3)만 '0'
                    // -> count++ 안 함
                } else {
                    count++;
                }
            }
            return count;
        }
        
        // -------------------------------------
        // 3) n>=2 => 5등분 블록으로 분할정복
        // -------------------------------------
        long blockSize = pow5[n - 1];  // 한 블록 길이 = 5^(n-1)
        long totalCount = 0;          // 결과 누적
        
        // n단계 문자열을 5블록으로 나눈다 (각 블록 길이 = blockSize)
        for(int blockIndex = 0; blockIndex < 5; blockIndex++) {
            long start = blockIndex * blockSize + 1; // 이 블록의 시작 인덱스
            long end   = start + blockSize - 1;      // 이 블록의 끝 인덱스
            
            // [start..end]가 [l,r]와 전혀 겹치지 않으면 패스
            if(end < l || start > r) continue;
            
            // 겹치는 부분만 추출
            long overlapLeft  = Math.max(l, start);
            long overlapRight = Math.min(r, end);
            
            // (n-1)단계 문자열에서 (blockIndex+1)번째 글자가 '1'이면 -> 이 블록은 "11011" 구조
            // '0'이면 -> "00000"
            long parentIndex = blockIndex + 1;
            if(isParentBitOne(n - 1, parentIndex)) {
                // 부모가 '1' => 실제 블록 내부에 '1'이 존재할 가능성 있음
                // => 하위 단계(n-1)로 재귀
                long newL = overlapLeft - start + 1;
                long newR = overlapRight - start + 1;
                
                totalCount += countOnes(n - 1, newL, newR);
            }
            // else => 부모가 '0' => 전부 '0', 카운트 X
        }
        
        return totalCount;
    }
    
    /**
     * (n단계)에서 pos번째 글자가 '1'인지 '0'인지 판별하는 함수
     *  - n=0 => "1"
     *  - n=1 => "11011" (가운데=3만 '0')
     *  - n>=2 => 분할정복으로 판단
     */
    private static boolean isParentBitOne(int n, long pos) {
        // 기저1: n=0 => 문자열이 "1" 한 글자뿐 => 항상 '1'
        if(n == 0) return true;
        
        // 기저2: n=1 => "11011" (길이=5), 가운데(3)는 '0'
        if(n == 1) {
            return (pos == 3) ? false : true;
        }
        
        // 일반 케이스 (n>=2)
        long blockSize = pow5[n - 1];
        
        // pos가 어느 블록(0~4)에 속하는지
        long blockIndex = (pos - 1) / blockSize;    
        long inBlockPos = (pos - 1) % blockSize + 1; // 해당 블록 내 상대 인덱스
        
        // (n-1)단계에서 (blockIndex+1)번째 글자가 0이면 -> 이 블록 전체가 '0'
        // 1이면 -> "11011" 구조
        boolean parent = isParentBitOne(n - 1, blockIndex + 1);
        
        if(!parent) {
            // 부모가 '0' => 여기 전부 0
            return false;
        } else {
            // 부모가 '1' => "11011" 패턴
            long subBlockSize = blockSize / 5;      // 더 작은 하위 블록의 길이
            long whichPart    = (inBlockPos - 1) / subBlockSize; // 0..4 중 어느 조각?
            
            // "11011"에서 중앙(2)만 0
            if(whichPart == 2) {
                return false;
            } else {
                // 그 외(0,1,3,4)는 '1' => 하지만 또 (n-2)단계 구조가 숨어 있을 수 있으므로 재귀
                long newPos = (inBlockPos - 1) % subBlockSize + 1;
                return isParentBitOne(n - 1, newPos);
            }
        }
    }
}