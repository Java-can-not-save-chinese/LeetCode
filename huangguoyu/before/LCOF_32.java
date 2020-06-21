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
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> resList = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            resList.add(temp.val);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        int[] res = new int[resList.size()];
        int i = 0;
        for(int item:resList) {
            res[i++] = item;
        }
        return res;
    }
}