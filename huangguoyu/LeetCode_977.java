
/**
给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

 

示例 1：

输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]
示例 2：

输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]
 

提示：

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A 已按非递减顺序排序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

找到最小值，利用双指针
*/
class Solution {
    public int[] sortedSquares(int[] A) {
        int gt0 = 0;
        for(int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                if (i > 0 && Math.abs(A[i]) > Math.abs(A[i - 1])) gt0 = i - 1;
                else gt0 = i;
                break;
            }
        }
        int inx = 0;
        int []res = new int[A.length];
        res[inx++] = A[gt0] * A[gt0];
        int p = gt0 - 1;
        int q = gt0 + 1;
        while(p >= 0 && q < A.length) {
            res[inx++] = (int)Math.min(Math.pow(A[p], 2),  Math.pow(A[q], 2));
            if(Math.abs(A[p]) < Math.abs(A[q])) p--;
            else q++;
        }
        while(p >= 0)
            res[inx++] = (int) Math.pow(A[p--], 2);
        while(q < A.length)
            res[inx++] = (int) Math.pow(A[q++], 2);
        return res;
    }
}