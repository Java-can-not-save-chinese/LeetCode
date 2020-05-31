package LeetCode.xinchengzhu.week9;

/***
 * 编写一个程序判断给定的数是否为丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例 1:
 *
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 示例 2:
 *
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 示例 3:
 *
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0263 {

    public static void main(String[] args) {

        System.out.println(isUgly(8));
    }

    public static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        boolean isUgly = false;

        int[] factor = new int[]{2,3,5};
        for(int i : factor){
            while (num %i == 0){
                num = num/i;
            }
        }

        if (num == 1){
            isUgly = true;
        }



        return isUgly;
    }

}
