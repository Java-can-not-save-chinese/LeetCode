class Solution {
    public int minCount(int[] coins) {
        int res = 0;
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] == 0) continue;
            res = res + coins[i] / 2 + (coins[i] % 2 == 0 ? 0 : 1);
        }
        return res;
    }
}