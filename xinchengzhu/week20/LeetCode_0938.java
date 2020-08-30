package week20;

import java.util.Stack;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *
 *
 * 提示：
 *
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。]
 */
public class LeetCode_0938 {


  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        System.out.println(rangeSumBST(root, 7, 15));
    }
    public static int rangeSumBST(TreeNode root, int L, int R) {
        //中序遍历
        int sum  = 0;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val > R){
                break;
            }
            if(root.val >= L && root.val <= R){
                sum += root.val;
            }
            root = root.right;
        }
        return sum;
    }

    public static void inOrder(TreeNode node, Integer sum, int L, int R){
      if(node == null){
          return;
      }
      int val = node.val;
      if(val > R){
          return;
      }
      inOrder(node.left, sum, L, R);
      inOrder(node.right, sum, L, R);
    }
}
