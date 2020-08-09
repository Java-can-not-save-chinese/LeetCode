class Solution {

    class Node {
        int first;
        int sec;
        public Node(int f, int s) {
            this.first = f;
            this.sec = s;
        }
    }

    public boolean stoneGame(int[] piles) {
        //计算n堆优先选择的结果实际上分为两个选择
        //1. 选择n，1-n 作为后手的最优选择
        //2. 选择1， 则2 - n作为后手的最优选择
        // 基本问题： 当只有一个选择时优先选择有值
        // dp[i][j].first = Math.max(dp[i][j - 1].sec + dp[j], dp[i + 1][j].sec + dp[i])
        // dp[i][j].sec = Math.max(dp[i][j - 1].sec + dp[j], dp[i + 1][j].sec + dp[i])
        Node dp[][] = new Node[piles.length][piles.length];
        int len = piles.length;
        for(int num = 0; num < piles.length; num++) { 
            for(int i = 0, j= num; i < len && j < len; i++, j++) {
                if (num == 0) {
                    Node temp = new Node(piles[j], 0);
                    dp[i][j] = temp;
                    continue;
                }
                int right = dp[i][j - 1].sec + piles[j];
                int left = dp[i + 1][j].sec + piles[i];
                dp[i][j] = new Node(
                    Math.max(dp[i][j - 1].sec + piles[j], dp[i + 1][j].sec + piles[i]),
                        left > right ? dp[i + 1][j].first : dp[i][j - 1].first
                );
            }
        }
        return (dp[0][len - 1].first - dp[0][len - 1].sec) > 0;
    }
}