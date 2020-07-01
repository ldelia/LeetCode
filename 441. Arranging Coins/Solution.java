class Solution {

    /**
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Arranging Coins.
    Memory Usage: 36.9 MB, less than 55.38% of Java online submissions for Arranging Coins.
    */

    public int arrangeCoins(int n) {  
    
        // binary search    
        long low = 1;
        long high = n;
        
        while (low <= high) {
            
            long middle = low + (high - low) / 2;
            long sum = coinsNeededForRow(middle);
            
            if (sum==n) return (int) middle;
            
            if (sum<n) {
                low = middle+1;
            } else {
                high = middle-1;
            }
        }
            
        return (int) high;
    }
    
    public long coinsNeededForRow(long r) {
        return r*(r+1)/2;
    }
}