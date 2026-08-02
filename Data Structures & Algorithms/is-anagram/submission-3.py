class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        s_hash = {}
        for ch in s:
            if ch in s_hash:
                s_hash[ch] += 1
            else:
                s_hash[ch] = 1

        for ch in t:
            if ch not in s_hash:
                return False
            else:
                s_hash[ch] -= 1

        for val in s_hash.values():
            if val != 0:
                return False
        return True