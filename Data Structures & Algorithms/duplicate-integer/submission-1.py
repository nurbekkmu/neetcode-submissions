class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        Hash = {}

        for num in nums:
            if num in Hash:
                return True
            else:
                Hash[num] = 1
                
        return False            

        