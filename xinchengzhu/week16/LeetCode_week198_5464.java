package week16;

/**
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * 请你计算 最多 能喝到多少瓶酒。
 *
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 *              9
 *
 *      (9+0) / 3 = 3 ... 0
 *
 *      (3+0) / 3 = 1 ... 0
 *
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
 *               15
 *
 *      (15+0) / 4 = 3 ... 3
 *
 *
 *      (3+3) / 4 = 1 ... 2
 *
 *      (1+2) / 4 =0 ... 3
 *
 */
public class LeetCode_week198_5464 {

    public static void main(String[] args) {

        System.out.println(numWaterBottles(15,4));
    }
    public static int numWaterBottles(int numBottles, int numExchange) {
            int total = numBottles;
            int fmod = 0;
            int fdiv =0;


            while ( (numBottles+fmod) / numExchange != 0){
                fdiv = (numBottles+fmod) / numExchange;
                fmod = (numBottles+fmod) % numExchange;
                numBottles = fdiv;
                total += fdiv;
            }

            return total;
    }
}
