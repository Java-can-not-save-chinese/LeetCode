class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        int[][] modifies = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;
                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i,j});
                grid[i][j] = 0;
                int temp = 1;
                while(!stack.isEmpty()){
                    int[] current = stack.pop();
                    for(int[] modify: modifies){
                        int next_i = current[0] + modify[0];
                        int next_j = current[1] + modify[1];
                        if(next_i >= 0 && next_i < m && next_j >= 0 && next_j < n && grid[next_i][next_j] == 1){
                            stack.add(new int[]{next_i,next_j});
                            temp += 1;
                            grid[next_i][next_j] = 0;
                        }
                    }
                }
                if(temp > result){
                    result = temp;
                }
            }
        }
        return result;
    }
}