class Solution {
    public int diagonalSum(int[][] mat) {
        int res = 0;
        int i = 0, j = 0;
        while (i < mat.length) 
            res += mat[i++][j++];
        
        i = mat.length - 1;
        j = 0;
        while(i >= 0) 
            res += mat[i--][j++];
        if (mat.length % 2 != 0)
            res -= mat[mat.length/2][mat.length/2];
        return res;
    }
}