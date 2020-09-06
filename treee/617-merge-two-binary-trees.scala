/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode = {
        var t: TreeNode = null
        
        if (t1 != null && t2 != null) {
            t = TreeNode(t1.value + t2.value)
            t.left = mergeTrees(t1.left, t2.left)
            t.right = mergeTrees(t1.right, t2.right)
        } else if (t1 == null && t2 != null) {
            t = TreeNode(t2.value)
            t.left = mergeTrees(null, t2.left)
            t.right = mergeTrees(null, t2.right)
        } else if (t2 == null && t1 != null) {
            t = TreeNode(t1.value)
            t.left = mergeTrees(t1.left, null)
            t.right = mergeTrees(t1.right, null)
        }
        
        t
    }
}
