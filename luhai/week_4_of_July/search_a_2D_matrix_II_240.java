class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while(row < m && col >= 0){
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] > target) col --;
            else row ++;
        }
        return false;
    }
}