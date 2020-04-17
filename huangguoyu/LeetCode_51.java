
/**
    N皇后问题
*/
class Solution {
    int len;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        len = n;
        List<String> route = new ArrayList<>();
        String s = "";
        for(int i = 0; i < n; i++) {
            s += ".";
        }
        for(int i = 0; i < n; i++) {
            route.add(new String(s));
        }

        backtrack(route, 0);
        
        return res;
    }

    public void backtrack(List<String> route, int row) {
        //判断是否满足条件
        if (row == route.size()) {
            res.add(new ArrayList<>(route));
            return;
        }

        //选择
        for(int i = 0; i < len; i++) {
            StringBuilder temp;
            String pre;
            if (isValid(route, row, i)) {
                temp = new StringBuilder(route.get(row));
                pre = route.get(row);
                temp.replace(i,i + 1, "Q");
                route.set(row, temp.toString());

                backtrack(route, row + 1);
                //回溯
                route.set(row, pre);
            }
        }
    }

    public boolean isValid(List<String> route, int row, int col) {
        // 列上
        for(int i = row; i >= 0; i--) {
            if (route.get(i).charAt(col) == 'Q') return false;
        }

        // 主对角线
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (route.get(i).charAt(j) == 'Q') return false;
        }

         // 主对角线
        for(int i = row - 1, j = col + 1; i >= 0 && j < len; i--, j++) {
            if (route.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }
}