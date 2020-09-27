/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

object Solution {
    def maxLevelSum(root: TreeNode): Int = {
        def maxSum(leafs: List[TreeNode], level: Int): (Int, Int) = {
            if (leafs.isEmpty) {
                (level, Integer.MIN_VALUE)
            } else {
                val s: Int = leafs.map(_.value).sum
                val newLeafs: List[TreeNode] = (leafs.map(_.left) ++ leafs.map(_.right)).filter(_ != null)
                val res = maxSum(newLeafs, level + 1)
                if (res._2 > s) {
                    res
                } else {
                    (level, s)
                }
            }
        }

        maxSum(List(root), 1)._1
    }
}
