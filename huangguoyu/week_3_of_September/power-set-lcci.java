class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        List<Integer> temp; 
        for(int i = 0; i < nums.length; i++) {
            temp = new ArrayList<>();
            temp.add(nums[i]);
            res.add(temp);
            for(int j = (i + 1); j < nums.length; j++)
                back_trace(j, nums, temp);
        }
        return res;
    }

    public void back_trace(int idx, int[] nums, List<Integer> route) {
        if (idx >= nums.length) return;
        route.add(nums[idx]);
        res.add(new ArrayList<>(route));
        for(int i = (idx + 1); i < nums.length; i++) {
            back_trace(i, nums, route);
        }
        route.remove(Integer.valueOf(nums[idx]));
    }

    public void add2res(int s, int e, int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for(int i = s; i <= e; i++) {
            temp.add(nums[i]);
        }
        res.add(temp);
    }
}