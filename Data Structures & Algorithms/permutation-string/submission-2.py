class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        
        def is_anogram(str1: str, str2: str) -> bool:
            return Counter(str1) == Counter(str2)

        if len(s1) > len(s2): return False

        l = 0
        r = len(s1)

        while r <= len(s2):
            if is_anogram(s1, s2[l:r]):
                return True
            else:
                l += 1
                r += 1
        return False            

        