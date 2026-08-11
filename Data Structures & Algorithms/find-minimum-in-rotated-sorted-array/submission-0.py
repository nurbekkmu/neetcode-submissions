class Solution:
    def findMin(self, nums: List[int]) -> int:
        res = max(nums)
        for n in nums:
            res = min(n, res)
        return res    
        