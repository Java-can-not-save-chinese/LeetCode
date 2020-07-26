class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int item : nums) 
            if (!set.add(item)) return true;
        return false;
    }
}