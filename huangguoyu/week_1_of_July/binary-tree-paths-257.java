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
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        if(root.left != null) {
            preOrder(root.left, root.val + "");
        }
        if(root.right != null) {
            preOrder(root.right, root.val + "");
        }
        return res;
    }


    public void preOrder(TreeNode root, String route) {
        if (root.left == null && root.right == null) {
            res.add(route + "->" + root.val);
            return;
        }
        if (root.left != null) {
            preOrder(root.left, route + "->" + root.val);
        }
        if (root.right != null) {
            preOrder(root.right, route + "->" + root.val);
        }
    }


}