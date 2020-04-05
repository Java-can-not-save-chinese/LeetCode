/**
 * @Description: 丑数就是只包含质因数 2, 3, 5 的正整数。
 * @Auther: zhurongsheng
 * @Date: 2020/4/5 10:21
 */
public class LeetCode_263 {

    public static void main(String[] args) {

        System.out.println(isUgly(6));
    }

    /**
     * 编写一个程序判断给定的数是否为丑数,丑数就是只包含质因数 2, 3, 5 的正整数。
     */
    public static boolean isUgly(int num) {

        if (num==1) return true;

        while (true) {
            if (num == 2 || num == 3 || num == 5) return true;
            if (num < 2) return false;

            if (num % 2 == 0) {
                num = num / 2;
                continue;
            }

            if (num % 3 == 0) {
                num = num / 3;
                continue;
            }

            if (num % 5 == 0) {
                num = num / 5;
                continue;
            }
            return false;
        }
    }
}




