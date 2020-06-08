package week10;


import org.omg.CORBA.NO_IMPLEMENT;

import javax.jws.soap.SOAPBinding;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/31 19:23
 */
public class LeetCode_04 {


    public static void main(String[] args) {


        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.left.left.left = new TreeNode(4);
        node.left.left.right = new TreeNode(4);

        System.out.println(isBalanced(node));
    }


    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }


    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
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
