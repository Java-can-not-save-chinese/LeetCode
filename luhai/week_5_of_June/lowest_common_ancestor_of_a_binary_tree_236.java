/**
 *Definition for a binary tree node.
 * public class TreeNode{
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x){val = x;}
 * }
 */
class Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,TreeNode q){
        if(help(root,p) && heljp(root,q)){
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            if(left != null) return left;
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            if(right != null) return right;
            return root;
        }
        return null;
    }
    private boolean help(TreeNode root,TreeNode child){
        if(root == null || child == null) return false;
        if(root == child) return true;
        return help(root.right,child) || help(root.left,child);
    }
}