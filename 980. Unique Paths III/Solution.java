
class Solution {

	/**
	Your runtime beats 60.26 % of java submissions.
	Your memory usage beats 67.65 % of java submissions.
	*/

    int[][] dirs = { {0,1}, {0,-1}, {1,0}, {-1,0} };
    
    public int uniquePathsIII(int[][] grid) {
        
        // 21.13 -> 21.49
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        Pair<Integer, Integer> startPoint = findPoint(grid, 1);
        int obstaclesCount = getObstaclesCount(grid);
        
        int longestPath = (grid.length * grid[0].length) - obstaclesCount;
        
        int ans = dfs(grid, startPoint.getKey(), startPoint.getValue(), visited, longestPath);
        
        return ans;
    }
    
    protected int dfs(
        int[][] grid, 
        int fromR, 
        int fromC,
        boolean[][] visited,
        int longestPath
    ) {
        if (fromR < 0 || fromR == grid.length) return 0;
        if (fromC < 0 || fromC == grid[0].length) return 0;
        if (grid[fromR][fromC] == -1) return 0;
        if (visited[fromR][fromC]) return 0;
        
        if (grid[fromR][fromC] == 2) {
            // reached the destination point
            return (longestPath == 1) ? 1 : 0; 
        }
        
        visited[fromR][fromC] = true;
        int ans = 0;
        for (int[] dir : dirs) {
            ans += dfs(
                grid, 
                fromR+dir[0], 
                fromC+dir[1],
                visited,
                longestPath-1
            );
        }
        visited[fromR][fromC] = false;
        return ans;
    }
    
    protected Pair<Integer, Integer> findPoint(int[][] grid, int value) {
        for (int c=0; c<grid.length; c++) {
            for (int r=0; r<grid[0].length; r++) {
                if (grid[c][r] == value) {
                    return new Pair<>(c, r);
                }
            }
        }
        return new Pair<>(0,0);
    }
    
    protected int getObstaclesCount(int[][] grid) {
        int count = 0;
        for (int c=0; c<grid.length; c++) {
            for (int r=0; r<grid[0].length; r++) {
                if (grid[c][r] == -1) {
                    count++;
                }
            }
        }
        return count;
    }
}