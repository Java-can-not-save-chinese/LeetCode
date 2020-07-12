class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {   // 这种情况下该问题退化为普通的股票交易问题->优化手段
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy,Integer.MIN_VALUE);
        for(int i = 0; i < prices.length; i++){
            for(int j = 1; j <= k; j ++){
                if(buy[j] < sell[j - 1] - prices[i]){
                    buy[j] = sell[j - 1] - prices[i];
                }
                if(sell[j] < buy[j] + prices[i]){
                    sell[j] = buy[j] + prices[i];
                }
            }
        }

        int result = 0;
        for(int i = 0; i <= k;i++){
            if(result < sell[i]) result = sell[i];
        }
        return result;
    }
}