import java.util.Arrays;

/**
 * @Description: 58最后一个单词的长度
 * @Auther: zhurongsheng
 * @Date: 2020/4/5 10:21
 */
public class LeetCode_58 {

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("Hello World"));

    }

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一
     * 个单词就是最后出现的单词。果不存在最后一个单词，请返回 0 。
     * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
     */
    public static int lengthOfLastWord(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        int index = chars.length - 1;
        while (index >= 0 && chars[index] == 32) index--;
        if (index < 0) return 0;
        while (index >= 0) {
            if (chars[index] == 32) {
                return ans;
            }
            ans++;
            index--;
        }
        return ans;
    }

}


