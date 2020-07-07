class Solution {
    
    int[][] dirs = { {1,0}, {-1,0}, {0, 1}, {0, -1} };
    
    public int islandPerimeter(int[][] grid) {
        
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return dfs(grid, r, c);
                }
            }
        }
        
        return 0;
    }
    
    protected int dfs(int[][] grid, int r, int c) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        return dfs(grid, r, c, visited);
    }
    
    protected int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        
        if (r == -1 || r == grid.length || c == -1 || c == grid[0].length || grid[r][c] == 0) {
            // water
            return 1;
        } 
        
        if (visited[r][c]) {
            // visited
            return 0;
        }
        
        visited[r][c] = true;
        
        int perimeter = 0;
        
        for (int[] d : dirs) {
            perimeter += dfs(grid, r + d[0], c + d[1], visited);
        }
        
        return perimeter;
    }
}