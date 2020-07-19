class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return;
        }
        m = board.length;
        n = board[0].length;
        for(int i = 0;i < m;i++){
            dfs(board,i,0);
            dfs(board,i,n - 1);
        }
        for(int i = 0;i < n;i++){
            dfs(board,0,i);
            dfs(board,m - 1,i);
        }
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    int[][] modifies = {{0,1},{0,-1},{1,0},{-1,0}};

    int m,n;

    public void dfs(char[][] board,int row,int col){
        if(row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O'){
            return;
        }
        board[row][col] = 'M';
        for(int[] modify : modifies){
            dfs(board,row + modify[0],col + modify[1]);
        }
    }
}