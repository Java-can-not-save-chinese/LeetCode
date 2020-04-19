package week02;


/**
 * @Description:
 * @Auther: zhurongsheng
 * @Date: 2020/4/19 16:26
 */
public class Leetcode_678 {


    /**
     * 贪心算法，计算当前需要最少右括号和最多右括号。遍历字符串，如果过程出现需要最多右括号小于0，返回失败,
     * 遍历结束如果需要最少右括号为0，返回成功。
     * <p>
     * <p>
     * (1) '(': 最少自增，最多自增
     * (2) '*': 最少大于0减一,最多自增
     * (3) ')'：最少大于0减一，自增减一
     */
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                if (low > 0) low--;
                high--;
                //如果high小于0，代表过程 '(' + '*' < ')'
                if (high < 0) {
                    return false;
                }
            } else {
                if (low > 0) low--;
                high++;
            }
        }
        return low == 0;
    }
}
