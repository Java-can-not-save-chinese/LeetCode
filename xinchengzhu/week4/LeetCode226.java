package LeetCode.xinchengzhu.week4;

/**
 *
 翻转一棵二叉树。

 示例：

 输入：

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 输出：

 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */
public class LeetCode226 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
