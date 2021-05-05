class Solution {
    public int jump(int[] nums) {
        
        if (nums.length == 1) return 0;
        
        int[] steps = new int[nums.length];
        int lastIndex = nums.length - 1;
        
        for (int i=0; i<nums.length; i++) {

            int lastStep = steps[i];
            
            for (int j = Math.min(nums[i], lastIndex-i); j > 0; j--) {
                
                if (lastStep >= steps[i+j] && steps[i+j] != 0) continue;
                
                steps[i+j] = 1 + lastStep;
                
                if (i+j == lastIndex) {
                    return steps[i+j];
                }
            }
        }
        return -1;
    }
}