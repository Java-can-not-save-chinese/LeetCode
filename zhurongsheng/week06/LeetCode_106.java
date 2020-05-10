package week06;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/10 16:05
 */
public class LeetCode_106 {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    private static TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {

        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }

        TreeNode treeNode = new TreeNode(postorder[pEnd]);
        int length = 0;
        while (inorder[length + iStart] != postorder[pEnd]) {
            length++;
        }
        treeNode.left = buildTree(inorder, iStart, iStart + length - 1, postorder, pStart, pStart + length - 1);
        treeNode.right = buildTree(inorder, iStart + length + 1, iEnd, postorder, pStart + length, pEnd - 1);
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
