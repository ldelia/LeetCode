class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        
        if len(points) == 0:
            return 0
        
        points.sort(key = lambda x: (x[0]))
                    
        maxValue = sys.maxsize
        
        arrows = 1
        for p in points:
            if (p[0] <= maxValue):
                maxValue = min(maxValue, p[1])
            else:
                arrows += 1
                maxValue = p[1]
        
        return arrows;
        