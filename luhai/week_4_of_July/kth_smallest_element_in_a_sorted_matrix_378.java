class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int l = matrix[0][0], h = matrix[m - 1][n - 1];
        while(l <= h){
            int med = l + (h - l) / 2;
            int cnt = 0;
            for(int i = 0; i < m;i++){
                for(int j = 0; j < n && matrix[i][j] <= med;j++){
                    cnt ++;
                }
            }
            if(cnt < k) l = med + 1;
            else h = med - 1;
        }
        return l;
    }
}