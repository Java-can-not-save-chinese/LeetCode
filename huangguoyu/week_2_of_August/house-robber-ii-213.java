class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // dp[i] 到i位置可获得的最大
        // dp[i] = Max(dp[i - 1], dp[i - 2] + nums[i])
        return Math.max(mob(Arrays.copyOfRange(nums, 0, nums.length - 1)), 
                        mob(Arrays.copyOfRange(nums, 1, nums.length)));

    }

    public int mob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        int res = Math.max(dp[0], dp[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            if (dp[i] > res) res = dp[i];
        } 
        return res;
    }
}