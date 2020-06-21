
//全局flag剪枝不能缺少， 满足条件得return只不过是递归中的某一层return
class Solution {
    String word;
    char[][] board;
    boolean flag = false;
    int[][] isUse;

    int row, col;
    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        row = board.length;
        col = board[0].length;
        isUse = new int[row][col];
        if ((col * row) < word.length()) return false;
        char c = word.charAt(0);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (board[i][j] == c) backtrace("", i, j, 0);
                if (flag) return flag;
            }
        }
        return flag;
    }

    /**
        全局flag剪枝不能缺少， 满足条件得return只不过是递归中的某一层return
    */
    public void backtrace(String s, int i, int j, int num) {
        s += board[i][j];
        isUse[i][j] = 1;

        //是否满足条件
        if (s.equals(word) || flag) {
            flag = true;
            return;
        }
        if (s.length() > word.length()) return;

        // 四个方向选择
        char c = word.charAt(num + 1);
        // up i - 1
        if ((i - 1) >= 0 && isUse[i - 1][j] == 0 && board[i - 1][j] == c) backtrace(s, i - 1, j, num + 1);
        //down i + 1
        if ((i + 1) < row && isUse[i + 1][j] == 0 && board[i + 1][j] == c) backtrace(s, i + 1, j, num + 1);
        //left j - 1
        if ((j - 1) >= 0 && isUse[i][j - 1] == 0 && board[i][j - 1] == c) backtrace(s, i, j - 1, num + 1);
        //right j + 1
        if ((j + 1) < col && isUse[i][j + 1] == 0 && board[i][j + 1] == c) backtrace(s, i, j + 1, num + 1);

        s = s.substring(0, s.length() - 1);
        isUse[i][j] = 0;
    }
}