package LeetCode.xinchengzhu.week8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class LeetCode_345 {

    /**
     * 元音字母  a e i o u
     */

    public static void main(String[] args) {
        String test = "hello";
        System.out.println(reverseVowels(test));
    }


    public static String reverseVowels(String s) {
        List<Integer> indexList = new LinkedList<>();
        char yuan[] = {'a','e','i','o','u','A','E','I','O','U'};
        StringBuilder sb = new StringBuilder();
        String yuanyin = String.valueOf(yuan);
        for(int i=0; i<s.length(); i++){
            //idnexList.set(index,0);
            if(yuanyin.indexOf(s.charAt(i)) != -1){
                indexList.add(i);
            }
        }
        for(int i=0; i<s.length(); i++){
            if(yuanyin.indexOf(s.charAt(i)) != -1){
                sb.append(s.charAt(indexList.get(indexList.size()-1)));
                indexList.remove(indexList.size()-1);
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
