class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTraceing(candidates,target,0,new ArrayList<>());
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    private void backTraceing(int[] candidates,int target,int start,ArrayList<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] <= target){
                list.add(candidates[i]);
                backTraceing(candidates,target - candidates[i],i,list);
                list.remove(list.size() - 1);
            }
        }
    }
}