class Solution {
    public int maxValue(int[][] grid) {
        //逆向求解，到大dp[i][j]可以获得的最大值
        // dp[i][j] = grid[i][j]  + Math.max(dp[i + 1][j], dp[i][j + 1])
        //初始情况 i = len - 1, 以及 j = len - 1;
        
        int ilen = grid.length;
        int jlen = grid[0].length;
        // 初始化基本数据
        for(int i = (ilen - 2); i >= 0; i--) 
            grid[i][jlen - 1] = grid[i][jlen - 1] + grid[i + 1][jlen - 1];

        for(int i = (jlen - 2); i >= 0; i--) 
            grid[ilen - 1][i] = grid[ilen - 1][i] + grid[ilen - 1][i + 1];

        for(int i = (ilen - 2); i >= 0; i--) {
            for(int j = (jlen - 2); j >= 0; j--) {
                 grid[i][j] =  grid[i][j]  + Math.max(grid[i + 1][j], grid[i][j + 1]);
            }
        }

        return grid[0][0];
    }
}