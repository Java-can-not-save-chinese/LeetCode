package LeetCode.xinchengzhu.week8;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class LeetCode_257 {


   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }


    public List<String> binaryTreePaths(TreeNode root) {
       List<String> list = new ArrayList<>();
       dfsTree(root,"",list);
       return list;
    }

    private void dfsTree(TreeNode root, String path, List<String> list) {
        if(root != null){
            path += root.val+"";
            if(root.right == null && root.left == null){
                list.add(path);
            }else{
                path+="->";
                if(root.left != null){
                    dfsTree(root.left, path, list);
                }
                if (root.right != null){
                    dfsTree(root.right, path, list);
                }
            }
        }
    }
}
