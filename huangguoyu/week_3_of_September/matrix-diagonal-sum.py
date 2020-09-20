class Solution(object):
    def diagonalSum(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: int
        """
        res = 0
        i = 0
        j = 0
        while(i < len(mat)):
            res += mat[i][j]
            i += 1
            j += 1
        i = len(mat) - 1;
        j = 0;
        while(i >= 0):
            res += mat[i][j]
            i -= 1 
            j += 1
        if (len(mat) % 2 != 0):
            res -= mat[len(mat) / 2][len(mat) / 2]
        return res