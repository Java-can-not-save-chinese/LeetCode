class Solution {
    public int[] runningSum(int[] nums) {
        int res[] = new int[nums.length];
        int temp = nums[0];
        res[0] = temp;
        for(int i = 1; i < nums.length; i++) {
            temp += nums[i];
            res[i] = temp;
        }
        return res;
    }
}