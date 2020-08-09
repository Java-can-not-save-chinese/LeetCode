class Solution {
    public int waysToStep(int n) {
        // 最优子结构： dp[i] 实际上是到i-1,i-2,i-3有多少种跳法
        // 方程： dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        long dp[] = new long[3];
        dp[0] = 1l;
        dp[1] = 2l;
        dp[2] = 4l;

        for(int i = 3; i < n; i++) {
            long temp = dp[2];
            dp[2] = ((dp[0] + dp[1] + dp[2]) % 1000000007);
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return (int)dp[2];
    }
}