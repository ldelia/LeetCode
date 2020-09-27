class Solution {
 
    /** 
    Your runtime beats 71.90 % of java submissions.
    Your memory usage beats 96.46 % of java submissions.    
    */

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        
        int eqNumber = 0;
        for (List<String> eq : equations) {
            
            HashMap<String, Double> connectionsFromA = graph.getOrDefault(eq.get(0), new HashMap<>());
            connectionsFromA.put(eq.get(1), values[eqNumber]);
            graph.put(eq.get(0), connectionsFromA);
            
            HashMap<String, Double> connectionsFromB = graph.getOrDefault(eq.get(1), new HashMap<>());
            connectionsFromB.put(eq.get(0), 1 / values[eqNumber]);
            graph.put(eq.get(1), connectionsFromB);
            
            eqNumber++;   
        }
        
        double[] ans = new double[queries.size()];
        
        int queryNumber = 0;
        for (List<String> q : queries) {
            Set<String> visited = new HashSet<>();
            ans[queryNumber] = calculate(graph, q.get(0), q.get(1), visited);
            queryNumber++;
        }
        return ans;
    }
    
    protected double calculate(HashMap<String, HashMap<String, Double>> graph, String from, String destination, Set<String> visited) {
        if (! graph.containsKey(from) || ! graph.containsKey(destination) || visited.contains(from)) return -1.0;
        if (from.equals(destination)) return 1.0;
        
        visited.add(from);
        HashMap<String, Double> connections = graph.get(from);
        
        if (connections.containsKey(destination)) {
            return connections.get(destination);
        }
        
        for (Map.Entry e : connections.entrySet()) {
            double partialRes = calculate(graph, (String) e.getKey(), destination, visited);
            
            if (partialRes != -1.0) {
                return (double) e.getValue() * partialRes;
            }
        }
        
        return -1.0;
    }
}