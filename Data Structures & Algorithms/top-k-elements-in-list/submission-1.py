from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Step 1: Count how many times each number appears
        frequency_map = {}

        for num in nums:
            if num in frequency_map:
                frequency_map[num] += 1
            else:
                frequency_map[num] = 1

        # Step 2: Create buckets
        # Index = frequency
        # Value = list of numbers that appear that many times
        buckets = [[] for _ in range(len(nums) + 1)]

        # Step 3: Put each number into the bucket that matches its frequency
        for num, freq in frequency_map.items():
            buckets[freq].append(num)

        # Step 4: Start from the highest frequency bucket
        # and collect numbers until we have k of them
        result = []

        for freq in range(len(buckets) - 1, 0, -1):
            for num in buckets[freq]:
                result.append(num)

                # Stop when we have collected k numbers
                if len(result) == k:
                    return result