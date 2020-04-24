package week02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: zhurongsheng
 * @Date: 2020/4/19 11:46
 */
public class LeetCode_22 {


    /**
     * 1 左括号和右括号的数目都是n
     * 2 当左括号的数目大于右括号时才能匹配右括号
     * 3 dfs
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        } else {
            String str = "";
            dfs(list, str, n, n);
            return list;
        }
    }

    private void dfs(List<String> list, String str, int left, int right) {

        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        //左括号的数目大于0
        if (left > 0) {
            dfs(list, str + "(", left - 1, right);
        }

        //当左括号的数目大于右括号时
        if (right > left) {
            dfs(list, str + ")", left, right - 1);
        }
    }


}
