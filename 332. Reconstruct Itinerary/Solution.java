/**
Runtime: 5 ms, faster than 80.69% of Java online submissions for Reconstruct Itinerary.
Memory Usage: 40.5 MB, less than 26.53% of Java online submissions for Reconstruct Itinerary.
*/
class Solution {
    
    List<String> resultList = new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            PriorityQueue<String> departures = map.getOrDefault(ticket.get(0), new PriorityQueue<String>());
            departures.offer(ticket.get(1));
            map.put(ticket.get(0), departures);
        }
        
        dfs(map, "JFK");
        
        return resultList;
    }
    
    protected void dfs(Map<String, PriorityQueue<String>> map, String origin) {
        
        PriorityQueue<String> departures = map.get(origin);
        while ( departures != null && ! departures.isEmpty()) {
            String destination = departures.poll();
            dfs(map, destination);
        }
        resultList.add(0, origin);
    }
}