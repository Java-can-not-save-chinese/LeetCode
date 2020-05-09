class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int max = 0, second = 0;
        if (nums[0] > nums[1]) {
            second = 1;
        } else {
            max = 1;
        }
        for(int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                second = max;
                max = i;
            } else if (nums[i] > nums[second]) {
                second = i;
            }
        }
        return nums[max] >= nums[second] * 2 ? max : -1;
    }
}