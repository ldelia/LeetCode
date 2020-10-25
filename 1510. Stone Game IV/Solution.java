/**
Runtime: 39 ms, faster than 49.74% of Java online submissions for Stone Game IV.
Memory Usage: 40.8 MB, less than 5.21% of Java online submissions for Stone Game IV.
*/

class Solution {
    public boolean winnerSquareGame(int n) {
        
        List<Integer> squares = new LinkedList<>();
        
        int lastSquare = 1;
        int i = 1;
        while (lastSquare <= n) {
            squares.add(lastSquare);
            i++;
            lastSquare = i * i;
        }
        
        Map<Integer, Boolean> dp = new HashMap<>();
        
        return winnerSquareGame(n, new ArrayList<>(squares), squares.size()-1, dp);
    }
    
    public boolean winnerSquareGame(int n, List<Integer> squares, int limit, Map<Integer, Boolean> dp) { 
        
        if (dp.containsKey(n)) return dp.get(n);
        
        Integer newLimit = null;
        
        for (int i=limit; i>=0; i--) {
            
            int nextScore = n - squares.get(i);
            
            if (nextScore < 0) continue;
            
            if (nextScore == 0) {
                dp.put(n, true);
                return true;   
            }
            
            if (newLimit == null) {
                newLimit = i;
            }
            
            if (! winnerSquareGame(nextScore, squares, newLimit, dp) ) {
                dp.put(n, true);
                return true;
            }
        }
        dp.put(n, false);
        
        return false;
    }
}