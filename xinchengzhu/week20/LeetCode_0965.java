package week20;

/**
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 */
public class LeetCode_0965 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isUnivalTree(TreeNode root) {
        if(root != null){
            return inOrder(root, root.val);
        }
        return true;
    }

    public static boolean inOrder(TreeNode node, int target){
        if(node == null){
            return true;
        }
        int val = node.val;
        if(val != target){
            return false;
        }
        boolean leftRes = inOrder(node.left, target);
        boolean rightRes = inOrder(node.right, target);
        return leftRes && rightRes;
    }

}
