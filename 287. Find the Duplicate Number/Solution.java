class Solution {
    
    /**
    Variation of Floyd's cycle-finding algorithm
    https://en.wikipedia.org/wiki/Cycle_detection#Floyd's_Tortoise_and_Hare
    */
    
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
	        fast = nums[nums[fast]];
        } while (slow != fast);
        
        // cycle founded!
        
        slow = nums[0];
        
        while (slow != fast) {
            slow = nums[slow];
	        fast = nums[fast];
        }
        
        return slow;
    }
}
