package LeetCode.xinchengzhu.week7;

/**
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */
public class LeetCode_058 {

    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int length = 0;


        String[] s1 = s.split(" ");
        int s1Length = s1.length;
        if(s1Length != 0){
            length = s1[s1Length-1].length();
        }
        return length;
    }
}
