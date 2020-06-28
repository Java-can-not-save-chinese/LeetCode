class Solution {
    public int missingNumber(int[] nums) {
        int res = -1;
        if (nums[0] != 0) return 0;
        if ((nums[nums.length - 1] != nums.length)) return nums.length;
        for(int i = 0; i < (nums.length - 1); i++) {
            if (nums[i] != (nums[i+1] - 1)) return nums[i] + 1;
        }
        return res;
    }
}