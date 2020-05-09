class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int num = Integer.MIN_VALUE;
        int window = 0;
        for(int i = 0; i < k; i++) {
            window += nums[i];
        }
        num = window;

        int p = 0, q = k;
        while(q < nums.length) {
            window = window + nums[q++] - nums[p++];
            if (window > num) num = window;
        }
        return num * 1.0 / k;
    }
}