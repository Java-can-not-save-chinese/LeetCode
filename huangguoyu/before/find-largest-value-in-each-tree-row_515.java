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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        int i = 0;
        int level = 1;
        int tempMax = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> to = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode item;
            int phaserMax = Integer.MIN_VALUE;
           while(!queue.isEmpty()) {
               item = queue.poll();
               if (item.val > phaserMax) phaserMax = item.val;
               to.add(item);
           }
           res.add(phaserMax);
           while(!to.isEmpty()) {
               item = to.poll();
               if(item.left != null) queue.add(item.left);
               if(item.right != null) queue.add(item.right);
           }
        }
        return res;
    }

    public int getLevel(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getLevel(root.left), getLevel(root.right)) + 1;
    }
}