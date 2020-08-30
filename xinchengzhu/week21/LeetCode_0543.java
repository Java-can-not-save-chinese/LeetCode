package week21;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class LeetCode_0543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int sum;
    public int diameterOfBinaryTree(TreeNode root) {
        sum =1;
        //计算出每个节点为起点需要经过的节点数
        //选出最大的一个
        //路径 = 经过的节点数 -1
        depth(root);
        return sum-1;
    }

    int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int L = depth(root.left);
        int R = depth(root.right);

        sum = Math.max(sum, L+R+1); //

        return Math.max(L, R) +1;
    }
}
