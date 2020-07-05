/**
 *Definition for a binary tree node.
 * public class TreeNode{
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x){val = x;}
 *     TreeNode(int val,TreeNode left,TreeNode right){
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Treenode> list = new ArrayList<>();
        if(root = null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }
}