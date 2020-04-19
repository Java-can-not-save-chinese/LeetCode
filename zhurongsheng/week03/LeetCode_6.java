package week02;


/**
 * @Description:
 * @Auther: zhurongsheng
 * @Date: 2020/4/17 23:06
 */
public class LeetCode_6 {

    public static void main(String[] args) {

        String str = convert("LEETCODEISHIRING", 3);

        System.out.println(str);
    }


    public static String convert(String s, int numRows) {

        //一行直接返回s
        if (numRows == 1) return s;
        //存储结果,初始化
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        //遍历chars
        char[] chars = s.toCharArray();
        int index = 0;

        /**
         *  Z字行走
         */
        while (index < chars.length) {
            for (int i = 0; i < numRows && index < chars.length; i++) {
                sbs[i].append(chars[index++]);
            }
            for (int i = numRows - 2; i >= 1 && index < chars.length; i--) {
                sbs[i].append(chars[index++]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(sbs[i]);
        }
        return sb.toString();
    }

}
