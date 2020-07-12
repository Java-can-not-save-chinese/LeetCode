class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        backTraceing(nums,new boolean[nums.length],new ArrayList<>());
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    private void backTraceing(int[] nums,boolean[] marked,List<Integer> list){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
        }
        boolean[] repeated = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(!marked[i] && !repeated[i]){
                list.add(nums[i]);
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[i] == nums[j]){
                        repeated[j] = true;
                    }
                }
                marked[i] = true;
                backTraceing(nums,marked,list);
                list.remove(list.size() - 1);
                marked[i] = false;
            }

        }
    }
}