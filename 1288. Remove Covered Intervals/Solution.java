class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        int remaining = intervals.length;
        
        for (int[] interval : intervals) {
            // check if the interval is covered by other intervals
            Map.Entry floorEntry = map.floorEntry(interval[0]);
            if (floorEntry != null && (int) floorEntry.getValue() >= interval[1]) {
                remaining--;
            } else {
                // check if the interval covers other intervals... 
                Map.Entry ceilingEntry = map.ceilingEntry(interval[0]);
                while (ceilingEntry != null && (int) ceilingEntry.getValue() <= interval[1]) {
                    map.remove(ceilingEntry.getKey());
                    remaining--;
                    ceilingEntry = map.ceilingEntry((int) ceilingEntry.getKey()+1);
                }
                map.put(interval[0], interval[1]);
            }
        }
        
        return remaining;
    }
}