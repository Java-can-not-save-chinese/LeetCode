package week05;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Auther: zhurongsheng
 * @Date: 2020/4/17 23:06
 */
public class LeetCode_893 {


    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i) {
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }




}
