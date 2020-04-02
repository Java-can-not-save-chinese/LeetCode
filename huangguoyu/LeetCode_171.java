/**
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28
示例 3:

输入: "ZY"
输出: 701

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/excel-sheet-column-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

26进制， 数字 * 对应位置权重
*/
class Solution {
    public int titleToNumber(String s) {
        Map<Character, Integer> num = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            num.put((char) ('A' + i), i + 1);
        }
        int len = s.length() - 1;
        int res = 0;
        for(char c : s.toCharArray()) {
            res += num.get(c) * Math.pow(26, len--);
        }
        return res;
    }
}