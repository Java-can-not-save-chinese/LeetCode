package week21;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class LeetCode_0557 {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start=0;
        int end = 0;

        for(int i=0; i< chars.length; i++){
            if(chars[i] == ' ' || i == chars.length-1){
                end=i;
                start = swap(chars,start, end);
            }
        }

        return new String(chars);
    }

    private static int swap(char[] chars, int start, int end) {
        int result = end+1;
        if(end  != chars.length-1){
            end = end -1;
        }
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        end = -1;
        return result;
    }
}
