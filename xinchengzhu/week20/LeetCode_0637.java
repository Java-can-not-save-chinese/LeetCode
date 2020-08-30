package week20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 */
public class LeetCode_0637 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        List<Integer> count = new ArrayList < > ();
        average(root, 0, list, count);
        for(int i=0; i<list.size(); i++){
            list.set(i, list.get(i) / count.get(i));
        }
        return list;
    }


    public static void average(TreeNode node, int i, List<Double> list, List<Integer> count){
        if(node == null){
            return;
        }
        int val = node.val;
        if(i < list.size()){
            list.set(i, list.get(i) + node.val);
            count.set(i, 1 + count.get(i));
        }else{
            list.add(1.0 * node.val);
            count.add(1);
        }
        average(node.left, i+1, list, count);
        average(node.right, i+1, list, count);
    }
}
