class Solution {
    public void solveSudoku(char[][] board) {
        backTraceing(board);
    }
    private boolean backTraceing(char[][] board){
        for(int i = 0; i < 9;i++){
            for(int j = 0; j < 9;j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        board[i][j] = k;
                        if(isTrue(board,i,j)){
                            if(!backTraceing(board)){
                                board[i][j] = '.';
                            }else{
                                return true;
                            }
                        }else{
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isTrue(char[][] board,int row,int column){
        return isVailed(board,row,column,true) && isVailed(board,row,column,false) && isVailed(board,row,column);
    }

    private boolean isVailed(char[][] board,int row,int column,boolean isRow){
        boolean[] marked = new boolean[10];
        for(int i = 0; i < 9; i++){
            int current = -2;
            if(isRow){
                current = board[row][i] - '0';
            }
            else{
                current = board[i][column] - '0';
            }
            current = current > 0 ? current : 0;
            if(current > 0 && marked[current]) return false;
            marked[current] = true;
        }
        return true;
    }

    private boolean isVailed(char[][] board,int row,int column){
        row = (row / 3) * 3;
        column = (column / 3) * 3;
        boolean[] marked = new boolean[10];
        for(int i = row; i < row + 3;i++){
            for(int j = column; j < column + 3;j++){
                int current = board[i][j] - '0';
                current = current > 0 ? current : 0;
                if(current > 0 && marked[current]) return false;
                marked[current] = true;
            }
        }
        return true;
    }
}