

class Solution {

    int len = 1000000;
    boolean flag = false;
    int[][] blocked;
    int[] target;
    Set<String> setx= new HashSet<>();
    Set<String> isUse = new HashSet<>();

    private Integer[][] directions = new Integer[][] {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };


    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if(blocked.length == 0 || (blocked.length == 1 && blocked[0].length == 1)) return true;
        this.blocked = blocked;
        this.target = target;

        for(int i = 0; i < blocked.length; i++) {
            setx.add(blocked[i][0] + "" + blocked[i][1]);
        }

        bfs(Arrays.stream(source).boxed().toArray(Integer[]::new));
        return flag;
    }

    public void bfs(Integer[] position) {

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(position);
        Integer[] item;
        while(!queue.isEmpty()) {
            item = queue.poll();
            //判断是否满足条件
            if(item[0].equals(target[0]) && item[1].equals(target[1])) {
                flag = true;
            }
            if (flag) return;

            // 广度搜索
            isUse.add(item[0] + "" + item[1]);
            
            for(Integer[] direction : directions) {
                int tempx = item[0] + direction[0];
                int tempy = item[1] + direction[1];
                if ((tempx >= 0 && tempx < len) && (tempy >= 0 && tempy < len)  && !isUse.contains(tempx + "" + tempy) && !setx.contains(tempx + "" + tempy)) queue.add(new Integer[]{tempx, tempy});
            }
        }
    }


}