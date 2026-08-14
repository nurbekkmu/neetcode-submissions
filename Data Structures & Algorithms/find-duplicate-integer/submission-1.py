class Solution:
    def findDuplicate(self, nums: List[int]) -> int:

        nums.sort() 

        seen = nums[0]
        for i in range(1, len(nums)):
            if seen == nums[i]:
                return seen
            else:
                seen = nums[i]