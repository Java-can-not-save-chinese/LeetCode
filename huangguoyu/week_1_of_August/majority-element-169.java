class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int res = 0;
        for(int item : nums) {
            if (map.get(item) == null) map.put(item, 1);
            else {
                map.put(item, map.get(item) + 1);
            }

            int curNum = map.get(item);
            if (curNum > max) {
                res = item;
                max = curNum;
            }
        }
        return res;
    }
}