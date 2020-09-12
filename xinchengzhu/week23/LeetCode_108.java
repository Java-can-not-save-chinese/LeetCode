package week23;

import sun.reflect.generics.tree.Tree;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class LeetCode_108 {
    /**
     * Definition for a binary tree node.
     * */
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    /**
     *
     * @param nums
     * @return
     *
     * 以数组中间的数字为中间节点
     * 然后分别选择两边的数字进行左右子树的构建
     *  左子树小于根节点
     *  右子树大于根节点
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode build = build(nums, 0, nums.length);
        return build;
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
