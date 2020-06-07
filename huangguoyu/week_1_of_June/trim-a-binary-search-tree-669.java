/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

 删除节点也就相当于从树根开始删，返回一个操作后的树根
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        root = cutL(root, L);
        root = cutR(root, R);
        return root;
    }


    public TreeNode cutL(TreeNode root, int L) {
        if (root == null) return null;
        if (root.val < L) {
            if (root.right != null) {
                return cutL(root.right, L);
            }
            else return null;
        } else {
            root.left = cutL(root.left, L);
            return root;
        }
    }

    public TreeNode cutR(TreeNode root, int R) {
        if (root == null) return null;
        if (root.val > R) {
            if (root.left != null) {
                return cutR(root.left, R);
            }
            else return null;
        } else {
            root.right = cutR(root.right, R);
            return root;
        } 
    }
}