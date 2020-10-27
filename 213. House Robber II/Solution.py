class Solution:
    def robHelper(self, nums: List[int], start: int, end: int) -> int:
        
        prev = 0
        last = nums[start]
        
        for i in range(start+1, end+1):
            
            prev_aux = prev
            
            if prev_aux + nums[i] > last:
                prev = last
                last = prev_aux + nums[i]
            else:
                prev = last

        return last
        
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 1: 
            return nums[0]
        
        if len(nums) == 2: 
            return max(nums[0], nums[1])
        
        return max(self.robHelper(nums, 0, len(nums)-2), self.robHelper(nums, 1, len(nums)-1))
        