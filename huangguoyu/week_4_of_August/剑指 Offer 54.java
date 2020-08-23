/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int num = 0;
    int res = 0;
    int rk = 0;
    String s = "";
    public int kthLargest(TreeNode root, int k) {
        rk = k;
        preOrder(root);
        preOrderK(root);
        return res;
    }


    public void preOrder(TreeNode root) {
        if (root != null) num++;
        if (root == null) return;
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderK(TreeNode root) {
        if (root == null) return;
        preOrderK(root.left);
        if (num == rk) {
            res = root.val;
        }
        num--;
        preOrderK(root.right);
    }
}