class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int ans = 0;
            
        int[] counters = new int[501];
        int[] targets = new int[]{60, 120, 180, 240, 300, 360, 420, 480, 540, 600, 660, 720, 780, 840, 900, 960};
        
        
        for (int t : time) {
            counters[t]++;
        }
        
        for (int t : time) {
            counters[t]--;
            for (int target : targets) {
                int q = target - t;
                if (q <= 0) {
                    continue;
                }
                if (q > 500) {
                    break;
                }
                ans += counters[q];
            }
        }
        
        return ans;
    }
}