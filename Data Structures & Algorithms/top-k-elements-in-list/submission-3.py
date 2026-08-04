class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Example:
        # nums = [1, 2, 2, 3, 3, 3], k = 2

        # Step 1: Create a dictionary to store frequency of each number
        # After this step:
        # count = {1: 1, 2: 2, 3: 3}
        count = {}

        # Step 2: Create buckets
        # buckets[i] will store all numbers that appear exactly i times
        # For nums = [1, 2, 2, 3, 3, 3]
        # len(nums) = 6
        # buckets = [[], [], [], [], [], [], []]
        freq = [[] for i in range(len(nums) + 1)]
        
        # Step 3: Count each number
        # Example:
        # n = 1 -> count = {1: 1}
        # n = 2 -> count = {1: 1, 2: 1}
        # n = 2 -> count = {1: 1, 2: 2}
        # n = 3 -> count = {1: 1, 2: 2, 3: 1}
        # n = 3 -> count = {1: 1, 2: 2, 3: 2}
        # n = 3 -> count = {1: 1, 2: 2, 3: 3}
        for n in nums:
            count[n] = 1 + count.get(n, 0)

        # Step 4: Put each number into the bucket that matches its frequency
        # Example:
        # count.items() = (1,1), (2,2), (3,3)
        # freq[1] = [1]
        # freq[2] = [2]
        # freq[3] = [3]
        for n, c in count.items():
            freq[c].append(n)

        # Step 5: Collect the top k frequent numbers
        # Start from the highest frequency bucket and move backwards
        # Example:
        # i = 6 -> []
        # i = 5 -> []
        # i = 4 -> []
        # i = 3 -> [3]   -> res = [3]
        # i = 2 -> [2]   -> res = [3, 2]
        # Stop because we collected k = 2 numbers
        res = []

        for i in range(len(freq) - 1, 0, -1):
            for n in freq[i]:
                res.append(n)
                if len(res) == k:
                    return res