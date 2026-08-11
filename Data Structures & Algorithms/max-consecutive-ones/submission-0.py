class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        mx = 0
        res = 0
        for i in nums:
            if i==1:
                mx+=1
                res = max(mx, res)
            else:
                mx=0
        return res            

        