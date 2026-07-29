class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROW = len(matrix)
        COL = len(matrix[0])

        for i in range(ROW):
            L = 0
            R = COL - 1

            while L <= R:
                M = (L + R)//2

                if target > matrix[i][M]:
                    L = M + 1
                elif target < matrix[i][M]:
                    R = M - 1
                else:
                    return True
        return False