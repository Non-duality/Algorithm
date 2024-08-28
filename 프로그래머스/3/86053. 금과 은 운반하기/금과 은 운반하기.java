class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = (long)1e15;

        while(left < right) {
            long mid = (left + right) / 2;

            if(transport(mid, a, b, g, s, w, t)){
                right = mid;
            } else{
                left = mid + 1;
            }

        }

        return left;
    }
    
        public static boolean transport(long time, int a, int b, int[] g, int[] s, int[] w, int[] t){

        long totalGold = 0;
        long totalSilver = 0;
        long totalMineral = 0;

        for(int i = 0; i < g.length; i++){
            long trips = time / (2 * t[i]);
            if(time % (2 * t[i]) >= t[i]) trips += 1;

            long maxGold = Math.min(g[i], trips * w[i]);
            long maxSilver = Math.min(s[i], trips * w[i]);
            long maxMineral = Math.min(g[i] + s[i], trips * w[i]);

            totalGold += maxGold;
            totalSilver += maxSilver;
            totalMineral += maxMineral;
        }

        return totalGold >= a && totalSilver >= b && totalMineral >= (a + b);
    }
}