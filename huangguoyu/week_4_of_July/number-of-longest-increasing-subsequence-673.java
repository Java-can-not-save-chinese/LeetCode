class Solution {
    public int findNumberOfLIS(int[] nums) {
        int maxSeqNum = 1;
        int dp[] = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        dp[0] = 1;
        map.put(1,1);
        for(int i = 1; i < nums.length; i++) {
            for(int j = (i - 1); j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == (dp[j] + 1)) {
                        Integer temp = map.get(dp[i]);
                        if (temp == null) map.put(dp[i], 2);
                        else map.put(dp[i], 2);
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == 0) {
                map.put(1, map.get(1) + 1);
            }
            dp[i] = Math.max(dp[i], 1);
            if (dp[i] > maxSeqNum) maxSeqNum = dp[i];
        }

        return map.get(maxSeqNum);
    }
}