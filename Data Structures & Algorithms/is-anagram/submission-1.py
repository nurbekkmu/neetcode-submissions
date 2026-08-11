class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        counter = {}
        for i in range(len(s)):
            counter[s[i]] = 1 + counter.get(s[i], 0)

        for ch in t:
            if ch not in counter:
                return False
            if ch in counter:
                if counter[ch] == 1:
                    del counter[ch]
                else:
                    counter[ch] -= 1

        return not counter                             
        