package week17;

/**
 *
 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。

 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。

 返回重新排列后的字符串。



 示例 1：



 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 输出："leetcode"
 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
 示例 2：

 输入：s = "abc", indices = [0,1,2]
 输出："abc"
 解释：重新排列后，每个字符都还留在原来的位置上。
 示例 3：

 输入：s = "aiohn", indices = [3,1,4,2,0]
 输出："nihao"
 示例 4：

 输入：s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
 输出："arigatou"
 示例 5：

 输入：s = "art", indices = [1,0,2]
 输出："rat"
 */
public class LeetCode_5472 {

    public static void main(String[] args) {
        int []indoces = new int[]{4,5,6,7,0,2,1,3};

        System.out.println(restoreString("codeleet", indoces));
    }

    public static String restoreString(String s, int[] indices) {
        char []cs = new char[s.length()];
        char []ss = s.toCharArray();
        for(int i=0; i<indices.length; i++){
            cs[indices[i]] = ss[i];
        }
        return new String(cs);

    }
}
