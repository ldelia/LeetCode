class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length==0) return 0;
        
        int profit = 0;         
        int lastLow = prices[0]; 
        int lastHigh = prices[0]; 
        int currentProfit = 0;
        
        for (int i=1; i<prices.length; i++) {
            
            if ((prices[i] < lastLow) || (lastHigh >= prices[i])) {
                // Should buy
                lastLow = prices[i];
                lastHigh = prices[i];
                profit += currentProfit;    
                currentProfit = 0;
            } else {
                lastHigh = prices[i];
            }
            currentProfit = Math.max(currentProfit, lastHigh - lastLow);
        }
        
        return profit + currentProfit;
    }
}