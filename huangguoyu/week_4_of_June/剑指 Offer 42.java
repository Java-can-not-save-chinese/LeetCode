class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int preSum =nums[0];
        if (preSum > res) res = preSum;

        for(int i = 1; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            res = Math.max(preSum, res);
        }
        return res;
    }
}