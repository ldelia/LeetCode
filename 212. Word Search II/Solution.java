

/**
Runtime: 28 ms, faster than 47.21% of Java online submissions for Word Search II.
Memory Usage: 50.7 MB, less than 13.70% of Java online submissions for Word Search II.
*/

class Solution {    

    static int[][] directions = new int[][]{ {0,1},{0,-1},{1,0},{-1,0} };
    
    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            
            root.addWord(word);
        }
        
        List<String> result = new LinkedList<>();
        
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                dfs(board, r, c, root, result);
            }
        }
        
        return result;
    }
    
    protected void dfs(char[][] board, int r, int c, TrieNode root, List<String> result) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        StringBuilder sb = new StringBuilder();
        dfs(board, r, c, root, result, visited, sb);
    }
    
    protected void dfs(char[][] board, int r, int c, TrieNode root, List<String> result, boolean[][] visited, StringBuilder sb) {
    
        if (r<0 || c<0 || r==board.length || c==board[0].length) return;
        if (visited[r][c]) return;
                    
        char letter = board[r][c];
        TrieNode TrieNode = root.get(letter);

        visited[r][c]=true;
        
        if (TrieNode != null) {

            sb.append(letter);
            
            if (TrieNode.isWord) {
                result.add(sb.toString());
                TrieNode.isWord = false;
            }
            
            for (int[] d : directions) {
                dfs(board, r + d[0], c + d[1], TrieNode, result, visited, sb);
            }
            
            //backtracking
            sb.deleteCharAt(sb.length() - 1);             
        }
        visited[r][c]=false;
    }
}