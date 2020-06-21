package week10;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/30 10:39
 */
public class LeetCode_102 {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrder(root);


    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> rs = new ArrayList<>();
        List<TreeNode> roots = new ArrayList<>();
        roots.add(root);
        while (!roots.isEmpty()) {
            //取当前层节点的值
            List<Integer> tempList = new ArrayList<>();
            //下层节点
            List<TreeNode> tempRoots = new ArrayList<>();
            for (TreeNode node : roots) {
                tempList.add(node.val);
                if (node.left != null) {
                    tempRoots.add(node.left);
                }
                if (node.right != null) {
                    tempRoots.add(node.right);
                }
            }
            rs.add(tempList);
            //更新roots的值
            roots.clear();
            roots = tempRoots;
        }
        return rs;
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
