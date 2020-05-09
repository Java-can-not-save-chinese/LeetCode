class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] res = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> item : map.entrySet())
            if (item.getValue() == 1) res[idx++] = item.getKey();

        return res;
    }
}