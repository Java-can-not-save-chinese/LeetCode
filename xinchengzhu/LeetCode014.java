package LeetCode.xinchengzhu;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode014 {


    public static void main(String[] args) {

    }


    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        //对字符串数组进行字典序排序
        Arrays.sort(strs);
        String first = strs[0];
        String end = strs[strs.length-1];

        int limit = Math.min(first.length(), end.length());

        for(int i=0; i<limit; i++){
            if(first.charAt(i) == end.charAt(i)){
                sb.append(first.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
