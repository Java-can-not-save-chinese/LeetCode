package week14;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_offer_050 {


    public static void main(String[] args) {
        System.out.println(firstUniqChar(""));
    }
   static   public char firstUniqChar(String s) {
        LinkedHashMap map = new LinkedHashMap(s.length());
        char res = ' ';
        for(char c : s.toCharArray()){
            int num = (int)map.getOrDefault(c, 0);
            map.put(c, num+1);
        }

        Set set = map.keySet();
        for(Object c : set){
            int num = (int)map.getOrDefault(c, 0);
            if(num == 1){
                res = (char)c;
                break;
            }
        }

        return res;
    }
}
