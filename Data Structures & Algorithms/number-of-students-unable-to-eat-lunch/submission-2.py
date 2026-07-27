class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        res = len(students)
        cnt = {}
        for s in students:
            if s not in cnt:
                cnt[s] = 0
            cnt[s] += 1

        for s in sandwiches:
            if s in cnt and cnt[s] > 0:
                cnt[s] -= 1
                res -= 1
            else:
                return res
        return res