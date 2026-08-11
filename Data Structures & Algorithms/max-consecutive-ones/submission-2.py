class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        mx = 0
        con = 0

        for num in nums:
            if num:
                con += 1
                mx = max(mx, con)
            else:
                con = 0    
        return mx