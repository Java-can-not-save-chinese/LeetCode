class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int item : nums) {
            if (map.get(item) != null) {
                set.remove(item);
                continue;
            }
            map.put(item, item);
            set.add(item);
        }
        for(int res : set) 
            return res;
        return 0;
    }
}