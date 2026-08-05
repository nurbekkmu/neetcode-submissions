class Solution:
    def isPalindrome(self, s: str) -> bool:
        cleaned = "".join(c.lower() for c in s if c.isalnum())
        L = 0
        R = len(cleaned) - 1

        while R > L:
            if cleaned[L] != cleaned[R]:
                return False
            L += 1
            R -= 1
        return True        
        