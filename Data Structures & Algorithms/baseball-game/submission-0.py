class Solution:
    def calPoints(self, operations: List[str]) -> int:

        res = []

        for ch in operations:
            if ch == 'C':
                res.pop()
            elif ch == "D":
                res.append(res[-1]*2)
            elif ch == '+':
                res.append(res[-2]+res[-1])
            else:
                res.append(int(ch))
        return sum(res)                    
        