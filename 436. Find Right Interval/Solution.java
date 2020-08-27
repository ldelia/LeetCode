class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        /**
        Runtime: 20 ms, faster than 77.06% of Java online submissions for Find Right Interval.
        Memory Usage: 47.8 MB, less than 50.00% of Java online submissions for Find Right Interval.
        */
        
        
        TreeMap<Integer, Integer> intervalMap = new TreeMap<>();
        
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            
            intervalMap.put(interval[0], i);
        }
        
        int[] result = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            
            int[] interval = intervals[i];
            
            Map.Entry e = intervalMap.ceilingEntry(interval[1]);
            
            result[i] = (e == null) ? -1 : (Integer) e.getValue();
        }
        
        return result;
    }
}