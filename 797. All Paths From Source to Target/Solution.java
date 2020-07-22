class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        /**
        Runtime: 4 ms, faster than 55.88% of Java online submissions for All Paths From Source to Target.
        Memory Usage: 52.9 MB, less than 5.13% of Java online submissions for All Paths From Source to Target.
        */

        List<List<Integer>> result = new LinkedList<>();
        
        int origin = 0;
        int dest = graph.length-1;
        
        List<Integer> currentPath = new LinkedList<>();
        currentPath.add(origin);
        
        dfs(origin, dest, graph, result, currentPath);
             
        return result;
    }
    
    protected void dfs(int origin, int dest, int[][] graph, List<List<Integer>> result, List<Integer> currentPath) {
        
        if (origin == dest) {
            result.add(new ArrayList<>(currentPath));
        }
        
        for (int c : graph[origin]) {
            currentPath.add(c);
            dfs(c, dest, graph, result, currentPath);
            currentPath.remove(currentPath.size()-1);
        }
    }
}