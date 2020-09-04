package week22;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 872. 叶子相似的树
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *
 *
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *
 *
 * 提示：
 *
 * 给定的两颗树可能会有 1 到 200 个结点。
 * 给定的两颗树上的值介于 0 到 200 之间。
 */
public class LeetCode_0872 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private int index = 0;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList list = getNode(root1);
        LinkedList node = getNode(root2);
        if(list.size() != node.size()){
            return false;
        }
        for(int i=0; i<list.size(); i++){
            Object o = list.get(i);
            Object o1 = node.get(i);
            if(o != o1){return false;}
        }

        return true;
    }

    private LinkedList getNode(TreeNode root1) {
        LinkedList list = new LinkedList();
        inOrder(root1, list);
        return list;
    }

    private void inOrder(TreeNode root1, LinkedList list) {
        if(root1 == null){
            return;
        }
        if(root1.left == null && root1.right == null){
            list.add(root1.val);
            return;
        }
        inOrder(root1.left, list);
        inOrder(root1.right, list);

    }
}
