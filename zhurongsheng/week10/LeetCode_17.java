package week10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/27 19:25
 */
public class LeetCode_17 {

    public static List<String> letterCombinations(String digits) {
        char[][] chars = new char[8][];
        chars[0] = new char[] {'a', 'b', 'c'};
        chars[1] = new char[] {'d', 'e', 'f'};
        chars[2] = new char[] {'g', 'h', 'i'};
        chars[3] = new char[] {'j', 'k', 'l'};
        chars[4] = new char[] {'m', 'n', 'o'};
        chars[5] = new char[] {'p', 'q', 'r', 's'};
        chars[6] = new char[] {'t', 'u', 'v'};
        chars[7] = new char[] {'w', 'x', 'y', 'z'};
        List<String> list = new ArrayList<>();
        if (!digits.isEmpty()) {
            dfs(chars, 0, list, digits, new StringBuilder());
        }
        return list;
    }

    private static void dfs(char[][] chars, int index, List<String> list, String digits, StringBuilder sb) {

        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }
        int temp = digits.charAt(index) - 48 - 2;
        for (int i = 0; i < chars[temp].length; i++) {
            sb.append(chars[temp][i]);
            dfs(chars, index + 1, list, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
