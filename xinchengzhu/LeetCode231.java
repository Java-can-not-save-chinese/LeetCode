package LeetCode.xinchengzhu;


/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo2(4096));
    }
    /***
     *
     * @param n
     * @return
     *
     * 2^0 =  1 = 1b
     * 2^1 =  2 = 10b
     * 2^2 =  4 = 100b
     * 2^3 =  8 = 1000‬b
     * 2^4 = 16 = 10000‬b
     */
    public static boolean isPowerOfTwo(int n) {
        if(n <=0 ){
            return false;
        }
        if(n == 1){
            return true;
        }
        String binStr =  Integer.toBinaryString(n);
        boolean isTrue = false;
        if(binStr.charAt(0) == '1'){
            String ten = Integer.valueOf(binStr.substring(1),2).toString();
            if(ten.equals("0")){
                isTrue = true;
            }
        }
        return isTrue;
    }


    public static boolean isPowerOfTwo2(int n) {
        if(n <=0 ){
            return false;
        }
        boolean isTrue = false;

        if((n & (n-1)) == 0){
            isTrue  = true;
        }

        return isTrue;
    }
}
