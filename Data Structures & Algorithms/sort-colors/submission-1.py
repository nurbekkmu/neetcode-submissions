class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        colors = [0, 0, 0]

        for n in nums:
            colors[n] += 1

        i = 0

        for n in range(len(colors)):
            for j in range(colors[n]):
                nums[i] = n
                i += 1

        return nums
