package week10;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/30 10:20
 */
public class LeetCode_49 {


    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int index = 1;
        while (index < n) {
            int min = Math.min(dp[index2] * 2, dp[index3] * 3);
            min = Math.min(dp[index5] * 5, min);
            dp[index++] = min;

            if (min == dp[index2] * 2) {
                index2++;
            }

            if (min == dp[index3] * 3) {
                index3++;
            }
            if (min == dp[index5] * 5) {
                index5++;
            }
        }
        return dp[n - 1];
    }


}
