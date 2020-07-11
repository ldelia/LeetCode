class Solution {

    /**
    Runtime: 1 ms, faster than 67.41% of Java online submissions for Subsets.
    Memory Usage: 39.8 MB, less than 46.83% of Java online submissions for Subsets.
    */

    public List<List<Integer>> subsets(int[] nums) {
        
        return subsets(nums, 0);
    }
    
    protected List<List<Integer>> subsets(int[] nums, int index) {
        
        List<List<Integer>> result = new LinkedList<>();
        
        if ( nums.length == index ) {
            result.add( new LinkedList<>() );
            return result;
        }
        
        int n = nums[index];
        
        List<List<Integer>> subResult = subsets(nums, index+1);

        for ( List<Integer> r : subResult ) {
            
            List<Integer> rc = new LinkedList();
            rc.addAll(r);
            
            r.add(0, n);
            
            result.add(r);
            result.add(rc);
        }

        return result;
    }
}