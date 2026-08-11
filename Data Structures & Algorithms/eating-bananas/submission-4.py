class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:        
        l, r = 1, max(piles)
        while l <= r:
            m = (l + r)//2
            hours = sum((pile+m-1)//m for pile in piles)
            if hours > h:
                l = m + 1
            else:
                r = m - 1
        return l