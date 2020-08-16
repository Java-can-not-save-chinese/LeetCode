package week19;

/**
 * 1189. “气球” 的最大数量
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 *
 *
 *
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 *
 * 输入：text = "leetcode"
 * 输出：0
 */
public class LeetCode_1189 {

    public static void main(String[] args) {
    }

    public int maxNumberOfBalloons(String text) {
        /**
         * 1个balloon
         *  需要 1 个 b
         *  需要 1 个 a
         *  需要 1 个 n
         *  需要 2 个 l
         *  需要 2 个 o
         */
        int balloon[] = new int[5];

        for(char c : text.toCharArray()){
            if(c == 'b'){
                balloon[0] +=1;
            }else if(c == 'a'){
                balloon[1] +=1;
            }else if(c == 'l'){
                balloon[2] +=1;
            }else if(c == 'o'){
                balloon[3] +=1;
            }else if(c == 'n'){
                balloon[4] +=1;
            }
        }

        balloon[2] = balloon[2] / 2;
        balloon[3] = balloon[3] / 2;

        int min = Integer.MAX_VALUE;
        for(int i =0; i<balloon.length; i++){
            if(balloon[i] < min){
                min = balloon[i];
            }
        }

        return min;
    }
}
