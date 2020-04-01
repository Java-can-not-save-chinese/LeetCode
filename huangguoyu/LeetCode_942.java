/**
给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。

返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：

如果 S[i] == "I"，那么 A[i] < A[i+1]
如果 S[i] == "D"，那么 A[i] > A[i+1]
 

示例 1：

输出："IDID"
输出：[0,4,1,3,2]
示例 2：

输出："III"
输出：[0,1,2,3]
示例 3：

输出："DDI"
输出：[3,2,0,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-string-match
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


循环每次获取最大最小即可
*/
public class Solution {

    public int[] diStringMatch(String S) {
        int p = 0, q = S.length();
        int res[] = new int[q + 1];
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'I')
                res[i] = p++;
            else 
                res[i] = q--;
        }
        res[S.length()] = p;
        return res;
    }
        
}