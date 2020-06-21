package week04;



/**
 * @Description:
 * @Auther: zhurongsheng
 * @Date: 2020/4/17 23:06
 */
public class LeetCode_66 {


    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
        } else {
            int index = digits.length - 1;
            while (index >= 0 && digits[index] == 9) {
                digits[index--] = 0;
            }
            //扩容
            if (index < 0) {
                int[] rs = new int[digits.length + 1];
                rs[0] = 1;
                return rs;
            }
            //不需要扩容
            else {
                digits[index] = digits[index] + 1;
            }
        }
        return digits;
    }

}
