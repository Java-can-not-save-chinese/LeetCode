class Solution {
    public boolean canPartition(int[] nums) {
        int sum = sum(nums);
        if (sum % 2 == 1) {
            return false;
        }
        int med = sum / 2;
        boolean[] dp = new boolean[med + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j >= nums[i])
                    dp[j] = dp[j - nums[i]] || dp[j];
            }
        }
        return dp[med];
    }

    public int sum(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }
}