class Solution {
    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0] > nums[1] ? nums[0] : nums[1];
        for(int i = 2; i < nums.length; i++) {
            int temp = nums[i];
            for(int j = 0; j < (i - 1); j++) {
                nums[i] = (temp + nums[j]) > nums[i] ? (temp + nums[j]) : nums[i];
            }
            if(nums[i] > max) max = nums[i];
        }
        return max;
    }
}