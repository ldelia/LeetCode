class Solution {
    
    public int numSquares(int n) {
        
        return numSquaresDP(n);
    }
    
    public int numSquaresDP(int n) {
        
        /**
        Runtime: 22 ms, faster than 87.12% of Java online submissions for Perfect Squares.
        Memory Usage: 39.3 MB, less than 37.71% of Java online submissions for Perfect Squares.
        **/
        
        int[] dp = new int[n+1];
        
        for (int i=1; i<=n; i++) {
            
            int sqrtVal = (int) Math.sqrt(i);
            
            if (sqrtVal * sqrtVal == i) {
                // is perfect square
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j=sqrtVal; j>=1; j--) {
                    min = Math.min( min, dp[i-j*j] + 1);
                }
                dp[i] = min;
            }
        }
        
        return dp[n];    
    }
    
    public int numSquaresRecursionSolution(int n) {

        /**
        Runtime: 777 ms, faster than 7.11% of Java online submissions for Perfect Squares.
        Memory Usage: 46.8 MB, less than 11.60% of Java online submissions for Perfect Squares.
        **/

        Map<Integer,Integer> cache = new HashMap<>();
        
        return numSquaresRecursionSolution(n, cache);
    }
    
    protected int numSquaresRecursionSolution(int n, Map<Integer,Integer> cache) {
        
        if (n == 0) return 0;
        
        if (cache.containsKey(n)) return cache.get(n);
        
        int leastNumber = Integer.MAX_VALUE;
        
        for (int i=(int)Math.sqrt(n); i>=1; i--) {
            int square = i*i;
            int currentRun = 1 + numSquaresRecursionSolution(n-square, cache);
            leastNumber = Math.min(leastNumber, currentRun);
        }
        
        cache.put(n, leastNumber);
        return leastNumber;
    }
}