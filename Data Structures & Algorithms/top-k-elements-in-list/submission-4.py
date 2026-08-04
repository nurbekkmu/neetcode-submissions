class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Example 1:
        # nums = [1, 2, 2, 3, 3, 3], k = 2
        #
        # Example 2:
        # nums = [1, 1, 1, 5, 100, 7, 7], k = 2

        # Step 1: Store how many times each number appears
        # Example 1:
        # count = {1: 1, 2: 2, 3: 3}
        #
        # Example 2:
        # count = {1: 3, 5: 1, 100: 1, 7: 2}
        count = {}

        # Step 2: Create empty buckets
        # Each index means a frequency
        # buckets[1] = numbers that appear 1 time
        # buckets[2] = numbers that appear 2 times
        # buckets[3] = numbers that appear 3 times
        #
        # Example 1: len(nums) = 6
        # buckets = [[], [], [], [], [], [], []]
        #
        # Example 2: len(nums) = 7
        # buckets = [[], [], [], [], [], [], [], []]
        buckets = []
        for _ in range(len(nums) + 1):
            buckets.append([])

        # Step 3: Count each number in nums
        # Example 1:
        # 1 -> {1: 1}
        # 2 -> {1: 1, 2: 1}
        # 2 -> {1: 1, 2: 2}
        # 3 -> {1: 1, 2: 2, 3: 1}
        # 3 -> {1: 1, 2: 2, 3: 2}
        # 3 -> {1: 1, 2: 2, 3: 3}
        #
        # Example 2:
        # 1 -> {1: 1}
        # 1 -> {1: 2}
        # 1 -> {1: 3}
        # 5 -> {1: 3, 5: 1}
        # 100 -> {1: 3, 5: 1, 100: 1}
        # 7 -> {1: 3, 5: 1, 100: 1, 7: 1}
        # 7 -> {1: 3, 5: 1, 100: 1, 7: 2}
        for n in nums:
            count[n] = 1 + count.get(n, 0)

        # Step 4: Put each number into the bucket that matches its frequency
        # Example 1:
        # 1 goes to buckets[1]
        # 2 goes to buckets[2]
        # 3 goes to buckets[3]
        #
        # buckets becomes:
        # [[], [1], [2], [3], [], [], []]
        #
        # Example 2:
        # 1 goes to buckets[3]
        # 5 goes to buckets[1]
        # 100 goes to buckets[1]
        # 7 goes to buckets[2]
        #
        # buckets becomes:
        # [[], [5, 100], [7], [1], [], [], [], []]
        for n, c in count.items():
            buckets[c].append(n)

        # Step 5: Start from the highest frequency bucket
        # and collect numbers until we have k elements
        #
        # Example 1:
        # Start from bucket 6 down to 1
        # bucket[3] = [3] -> res = [3]
        # bucket[2] = [2] -> res = [3, 2]
        # Stop because k = 2
        #
        # Example 2:
        # Start from bucket 7 down to 1
        # bucket[3] = [1] -> res = [1]
        # bucket[2] = [7] -> res = [1, 7]
        # Stop because k = 2
        res = []

        for i in range(len(buckets) - 1, 0, -1):
            for n in buckets[i]:
                res.append(n)
                if len(res) == k:
                    return res