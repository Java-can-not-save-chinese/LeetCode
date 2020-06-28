class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0) return 0;
        if(grid[0][0] == 1) return -1;
        help(grid,new int[]{0,0},new int[]{grid.length - 1,grid.length - 1},1);
        int finally_result = Integer.MAX_VALUE;
        for(int i = 0; i < result.size(); i++){
            if(result.get(i) < finally_result){
                finally_result = result.get(i);
            }
        }
        return finally_result == Integer.MAX_VALUE ? -1 : finally_result;
    }

    List<Integer> result = new ArrayList<>();

    private void help(int[][] grid,int[] start,int[] end,int length){
        if(start[0] == end[0] && start[1] == end[1]){
            result.add(length);
            return;
        }
        for(int i = -1; i < 2;i ++){
            for(int j = -1; j < 2;j++){
                if(i == 0 && j == 0) continue;
                int end_i = start[0] + i ;
                int end_j = start[1] + j;
                try{
                    if(grid[end_i][end_j] == 0){
                        grid[start[0]][start[1]] = 1;
                        help(grid,new int[]{end_i,end_j},end,length + 1);
                        grid[start[0]][start[1]] = 0;
                    }
                }catch(Exception e){
                    continue;
                }

            }
        }
    }
}