class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        maxLeft = [0] * n # O(n) Space
        maxLeft[0] = 0
        maxL = 0

        maxRight = [0] * n # O(n) Space
        maxRight[-1] = 0
        maxR = 0
        
        for i in range(len(height) - 1): # O(n) Time
            maxL = max(maxL, height[i])
            maxLeft[i + 1] = maxL

        for i in range(len(height) - 1, 0, -1): # O(n) Time
            maxR = max(maxR, height[i])
            maxRight[i - 1] = maxR

        res = 0

        for i in range(len(height)): # O(n) Time
            res += max(0, (min(maxRight[i], maxLeft[i]) - height[i])) 

        return res