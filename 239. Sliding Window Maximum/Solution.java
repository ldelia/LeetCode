class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];
        
        Deque<Integer> maxWin = new LinkedList<>();
                
        int ansId = 0;
        
        for (int i=0; i<nums.length; i++) {
            
            // remove max elements out of range
            while (! maxWin.isEmpty() && maxWin.peekFirst() < i-k+1) {
                maxWin.removeFirst();
            }
            
            // remove elements from the tail that are lower than nums[i]
            while (! maxWin.isEmpty() && nums[maxWin.peekLast()] < nums[i]) {
                maxWin.removeLast();
            }
            
            maxWin.addLast(i);
            
                        
            if (i>=k-1) {
                ans[ansId] = nums[maxWin.peekFirst()];
                ansId++;                
            }            
        }
        
        return ans;
    }
}