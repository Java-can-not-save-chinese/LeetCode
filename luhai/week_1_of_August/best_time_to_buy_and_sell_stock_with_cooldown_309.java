class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length <= 1) return 0;
        int buy,sell,buffer;//分别记录当前买,卖,卖后可买 时的最大收益
        buy = -prices[0];
        sell = buffer = 0;
        for(int i = 1; i < prices.length;i++){
            buy = Math.max(buffer - prices[i],buy);
            buffer = Math.max(sell,buffer);
            sell = buy + prices[i];
        }
        return Math.max(sell,buffer);
    }
}