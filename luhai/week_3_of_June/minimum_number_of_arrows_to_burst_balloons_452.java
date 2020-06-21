class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        Arrays.sort(points,(a,b)->{
            if(a[1] != b[1]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        int result = 1;
        int point = points[0][1];
        for(int i = 0;i < points.length;i++){
            if (points[i][0] > point){
                point = points[i][1];
                result ++;
            }
        }
        return result;
    }
}