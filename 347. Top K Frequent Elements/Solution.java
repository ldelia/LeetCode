class Solution {
    /**
    Runtime: 9 ms, faster than 90.20% of Java online submissions for Top K Frequent Elements.
    Memory Usage: 42 MB, less than 61.44% of Java online submissions for Top K Frequent Elements.
    */
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> ocurrences = new HashMap<>();
        
        for (int n : nums) {
            int o = ocurrences.getOrDefault(n, 0);
            ocurrences.put(n, o+1);
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, (a,b) -> a[1] - b[1] );
        
        for (Map.Entry e : ocurrences.entrySet()) {
            
            minHeap.offer( new int[]{ (int) e.getKey(), (int) e.getValue() } );
            
            if (minHeap.size() == k+1) {
                minHeap.poll();
            }
        }
        
        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            int[] p = minHeap.poll();
            result[i] = p[0];
        }
        
        return result;
    }
}