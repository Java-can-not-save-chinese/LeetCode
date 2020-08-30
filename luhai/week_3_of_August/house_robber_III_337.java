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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        int child = 0,self = root.val;
        if(root.left != null){
            child += rob(root.left);
            self += rob(root.left.left);
            self += rob(root.left.right);
        }
        if(root.right != null){
            child += rob(root.right);
            self += rob(root.right.left);
            self += rob(root.right.right);
        }
        return Math.max(child,self);
    }
}