package LeetCode.xinchengzhu.week6;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_100 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        return sameTree(p, q);
    }
    boolean sameTree(TreeNode t1, TreeNode t2){
        if( (t1==null && t2==null) ){
            return true;
        }if( (t1!=null && t2!= null) ){
            if(t1.val != t2.val){
                return false;
            }else{
                boolean left = sameTree(t1.left, t2.left);
                boolean right = sameTree(t1.right, t2.right);
                if(left && right){
                    return true;
                }else{
                    return false;
                }
            }
        }else{
            return false;
        }
    }
}
