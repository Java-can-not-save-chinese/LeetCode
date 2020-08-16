package week19;

import java.util.HashMap;
import java.util.Set;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 */
public class LeetCode_01_02 {

    public static void main(String[] args) {
        CheckPermutation("abc", "bad");
    }

    public static boolean CheckPermutation(String s1, String s2) {
        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        int i=0;
        while (i < s1.length() || i < s2.length()){
            if(i < s1.length()){
                m1.put(s1.charAt(i),m1.getOrDefault(s1.charAt(i),0)+1);
            }
            if(i < s2.length()){
                m2.put(s2.charAt(i),m2.getOrDefault(s2.charAt(i),0)+1);
            }
            i++;
        }

        Set<Character> m1Keys = m1.keySet();
        Set<Character> m2Keys = m2.keySet();

        if(m1Keys.size() != m2Keys.size()){
            return false;
        }

        for(char c : m1Keys){
            Integer r1 = m1.getOrDefault(c, 0);
            Integer r2 = m2.getOrDefault(c, 0);

            if(r1 == 0 || r2 == 0){
                return false;
            }

            if(r1 != r2){
                return false;
            }
        }

        return true;
    }
}
