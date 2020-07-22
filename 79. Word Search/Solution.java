class Solution {

    /** 
    Runtime: 6 ms, faster than 66.12% of Java online submissions for Word Search.
    Memory Usage: 41.9 MB, less than 13.57% of Java online submissions for Word Search.
    */
    
    protected int[][] dirs = { {0,-1}, {0,1}, {-1,0}, {1,0} };
    
    public boolean exist(char[][] board, String word) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                if (dfs(board, r, c, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected boolean dfs(char[][] board, int r, int c, String word, int wordPosition, boolean[][] visited) {
        
        if (wordPosition == word.length()) return true; // we reached the final of the word
        
        if (r < 0 || r==board.length) return false;
        if (c < 0 || c==board[0].length) return false;        
        if (word.charAt(wordPosition) != board[r][c]) return false;
        if (visited[r][c]) return false;
        
        // current char is equals to board[r][c]. 
        
        visited[r][c] = true;
        
        // check neighbours
        for (int[] dir : dirs) {
            if (dfs(board, r+dir[0], c+dir[1], word, wordPosition+1, visited)) {
                return true;
            }
        }
        
        visited[r][c] = false;
        
        return false;
    }
}