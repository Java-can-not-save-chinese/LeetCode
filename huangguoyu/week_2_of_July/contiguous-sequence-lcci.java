class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        // int dp[] = new int[nums.length];
        // dp[0] = res;
        int dp = res;
        for(int i = 1; i < nums.length; i++) {
            // dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            dp = Math.max(nums[i], nums[i] + dp);
            if (dp > res) res = dp;
        }
        return res;
    }
}