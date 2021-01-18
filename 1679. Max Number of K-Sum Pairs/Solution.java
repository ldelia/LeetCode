class Solution {
    public int maxOperations(int[] nums, int k) {
        
        /*
        Your runtime beats 85.78 % of java submissions.
        Your memory usage beats 91.01 % of java submissions.
        */
        
        int operations = 0;
        
        HashMap<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
        
        for (int n : nums) {
            if (n >= k) continue;
            
            int diff = k - n;
            
            int elements = mapCount.getOrDefault(diff, 0);
            if (elements > 0) {
                
                if (elements == 1) {
                    mapCount.remove(diff);
                } else {
                    mapCount.put(diff, elements - 1);
                }
                operations++;
            } else {
                mapCount.put(n, mapCount.getOrDefault(n, 0) + 1);
            }
        }
        
        return operations;
    }
}