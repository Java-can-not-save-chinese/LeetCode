/**
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < (i + 1); j++) {
                if(j == i) temp.add(1); 
                else temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            res.add(temp);
        }
        return res;
    }
}