package LeetCode.xinchengzhu.week7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class LeetCode_107 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrderBottom(root);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        int length = getLength(root);
        List<List<Integer>> result = new ArrayList<>(length);
        for(int i=0; i<length; i++){
            List<Integer> li = new ArrayList<>();
            result.add(li);
        }

        int index = length - 1;
        levelOrderBottom(root,index,result);

        return result;
    }

    public static void levelOrderBottom(TreeNode root, int depth, List<List<Integer>> lists){
        if(root == null){
            return;
        }
        lists.get(depth).add(root.val);
        depth = depth -1;
        levelOrderBottom(root.left, depth, lists);
        levelOrderBottom(root.right, depth, lists);
    }



    public static int getLength(TreeNode root){
        if(root == null){
            return 0;
        }else{

            return Math.max(getLength(root.left), getLength(root.right))+1;
        }
    }
}
