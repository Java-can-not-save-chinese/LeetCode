class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] globalMarked = new boolean[numCourses]; //优化手段
        boolean[] localMarked = new boolean[numCourses];
        List<Integer>[] graphic = new List[numCourses];
        for(int i = 0; i < graphic.length;i++){
            graphic[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length;i ++){
            graphic[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i = 0; i < numCourses;i++){
            if(hasCycle(globalMarked,localMarked,graphic,i)){
                return false;
            }
        }
        return true;
    }
    public boolean hasCycle(boolean[] globalMarked,boolean[] localMarked,List<Integer>[] graphic,int cur){
        if(localMarked[cur]) return true;
        if(globalMarked[cur]) return false;
        localMarked[cur] = true;
        globalMarked[cur] = true;
        for(Integer child : graphic[cur]){
            if(hasCycle(globalMarked,localMarked,graphic,child)){
                return true;
            }
        }
        localMarked[cur] = false;
        return false;
    }
}