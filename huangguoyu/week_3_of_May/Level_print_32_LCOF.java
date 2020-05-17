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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        
        while(temp.size() != 0) {
            List<Integer> item = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
            for(TreeNode it : temp) {
                item.add(it.val);
                if (it.left != null) nextLevel.add(it.left);
                if (it.right != null) nextLevel.add(it.right);
            }
            res.add(item);
            temp.clear();
            temp = nextLevel;
        }
        return res;
    }
}