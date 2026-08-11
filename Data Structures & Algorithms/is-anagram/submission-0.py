class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        counter = {}
        for ch in s:
            if ch in counter:
                counter[ch] += 1
            else:
                counter[ch] = 1

        for ch in t:
            if ch not in counter:
                return False
            if ch in counter:
                if counter[ch] == 1:
                    del counter[ch]
                else:
                    counter[ch] -= 1

        return not counter                             
        