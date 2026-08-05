class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        maxLeft = [0] * n 
        maxLeft[0] = 0
        maxL = 0

        maxRight = [0] * n 
        maxRight[-1] = 0
        maxR = 0
        
        for i in range(len(height) - 1):
            maxL = max(maxL, height[i])
            maxLeft[i + 1] = maxL

        for i in range(len(height) - 1, 0, -1):
            maxR = max(maxR, height[i])
            maxRight[i - 1] = maxR

        res = 0

        for i in range(len(height)): 
            res += max(0, (min(maxRight[i], maxLeft[i]) - height[i])) 

        return res


        # Time complexity: O ( n ) O(n) Space complexity: O (1)