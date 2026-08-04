class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        # nums = [1, 1, 1, 5, 100, 7, 7], k = 2
        # Step 1: Store how many times each number appears
        # count = {1: 3, 5: 1, 100: 1, 7: 2}
        count = {}

        # Step 2: Create empty buckets
        # Each index means a frequency
        # Example 2: len(nums) = 7
        # buckets = [[], [], [], [], [], [], [], []]
        buckets = []
        for _ in range(len(nums) + 1):
            buckets.append([])

        # Step 3: Count each number in nums
        # Example 1:     
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