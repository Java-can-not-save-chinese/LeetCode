class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result = Math.max(result,dfs(grid,i,j));
            }
        }
        return result;
    }

    int[][] modifies = {{0,1},{0,-1},{1,0},{-1,0}};

    int m,n;

    public int dfs(int[][] grid,int row,int col){
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0){
            return 0;
        }
        int result = 1;
        grid[row][col] = 0;
        for(int[] modify : modifies){
            result += dfs(grid,row + modify[0],col + modify[1]);
        }
        return result;
    }
}