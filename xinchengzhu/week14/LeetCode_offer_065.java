package week14;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *  
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_offer_065 {
    public static void main(String[] args) {

        System.out.println(add(13,9));
    }


    /**
     *
     * @param a
     * @param b
     * @return
     *
     * 二进制加法，刚开始只想到了异或，但是那是在没有进位的情况下才有效的解法;
     * 然后去翻了解答
     *
     * 二进制中计算进位用的是 与 逻辑 ，需要向左移动一位， 如果没有进位 ，左移仍然是0，所以不影响
     * 在代码中，
     *  1.先计算无进位的值，
     *  2.再计算进位
     *  3.进行递归判断，如果上述步骤中的任意一个结果为0，则表示递归结束
     *  否则，说明进位还没有完全计算完，
     *
     */

    public static int add(int a, int b) {
        if(a == 0){
            return b;
        }
        if(b == 0){
            return a;
        }
        int result1 = a ^ b;
        int result2 = (a & b) << 1;
        return add(result1, result2);
    }
}
