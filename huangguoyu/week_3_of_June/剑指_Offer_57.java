class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int res[] = new int[2];
        for(int item : nums) {
            if (map.get(target - item) != null) {
                res[0] = item;
                res[1] = map.get(target - item);
            } else {
                map.put(item, item);
            }
        }
        return res;
    }
}