package week08;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/20 22:54
 */
public class LeetCode_0408 {


    /**
     * 已知：
     * 所有节点的值都是唯一的。p、q 为不同节点且均存在于给定的二叉树中。
     * <p>
     * 结论：
     * (1) 当p是q的子树(q是p的子树)，则p==root || q==root ，root是其公共祖先。
     * (2) root是p(q)的祖先，在root的左子树发现p（q），在root的右子树发现q(p)，返回root。
     * (3) 左子树为空去右子树找，右子树为空去左子树找。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
                                         TreeNode q) {
        if (root == null) {
            return null;
        }
        //子树关系
        if (p == root || q == root) {
            return root;
        }
        //root为p,q的祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        //左子树空去右子树找，右子树为空去左子树找
        return left != null ? left : right;

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
