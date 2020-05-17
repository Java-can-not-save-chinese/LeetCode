package week06;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/9 00:44
 */
public class LeetCode_105 {


    public static void main(String[] args) {

        


    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int lenLeft = index - inStart;
        treeNode.left = buildTree(preorder, inorder, preStart + 1, preStart + lenLeft, inStart, index - 1);
        treeNode.right = buildTree(preorder, inorder, preStart + lenLeft + 1, preEnd, index + 1, inEnd);
        return treeNode;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
