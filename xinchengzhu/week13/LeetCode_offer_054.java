package week13;

import java.util.LinkedList;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_offer_054 {


    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public int kthLargest(TreeNode root, int k) {

        //利用中序遍历，将二叉树转换为一个有序列表
        LinkedList array = new LinkedList();
        PreOrderTraverse(array, root);
        //则第K个元素的位置为 index = array.size - k;

        int index = array.size() - k -1;
        int result = (int)array.get(index);

        return result;

    }


    private void PreOrderTraverse(LinkedList array, TreeNode tree){
        if(tree == null){
            return;
        }
        PreOrderTraverse(array, tree.left);
        array.add(tree.val);
        PreOrderTraverse(array, tree.right);
    }
}
