class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        
        sorted_intervals = sorted(intervals, key = lambda x: x[0])
        
        minLastInterval = sorted_intervals[0][0]
        maxLastInterval = sorted_intervals[0][1]
        
        ans = len(sorted_intervals)
        
        for i in range(1,len(sorted_intervals)):

            if sorted_intervals[i][1] <= maxLastInterval:
                ans -= 1
            else:
                if minLastInterval ==  sorted_intervals[i][0]:
                    ans -= 1                
                minLastInterval = sorted_intervals[i][0]
                maxLastInterval = sorted_intervals[i][1]
            
            
        return ans