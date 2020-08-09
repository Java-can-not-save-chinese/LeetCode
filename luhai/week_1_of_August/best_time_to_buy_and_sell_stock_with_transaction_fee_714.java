class Solution {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int buy, sell;
        buy = -prices[0];
        sell = 0;
        for(int i =0; i < length; i++){
            buy = Math.max(sell - prices[i],buy);
            sell = Math.max(buy + prices[i] - fee,sell);
        }
        return sell;
    }
}