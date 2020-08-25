class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        /**
Runtime: 1 ms, faster than 89.33% of Java online submissions for Minimum Cost For Tickets.
Memory Usage: 37.1 MB, less than 94.23% of Java online submissions for Minimum Cost For Tickets.
        */
        
        int[] dp = new int[days[days.length-1]+1];
        
        int cheapOption = Integer.MAX_VALUE; 
        for (int i = 0; i<costs.length; i++) {
            cheapOption = Math.min(cheapOption, costs[i]); 
        }
        
        dp[days[0]] = cheapOption;

        for (int i = 1; i<days.length; i++) {
            
            for (int j = days[i-1]+1; j<days[i]; j++) {
                dp[j] = dp[j-1];
            }
            
            int day = days[i]; 
            
            int sevenDaysBefore = Math.max(day - 7, 0);
            int thirtyDaysBefore = Math.max(day - 30, 0);
            
            int bestDeal = Math.min(dp[sevenDaysBefore] + costs[1], dp[day-1] + cheapOption);
            bestDeal = Math.min(bestDeal, dp[thirtyDaysBefore] + costs[2]);
            
            dp[day] = bestDeal;
        }
        
        return dp[days[days.length-1]];
    }
}