/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

object Solution {
    def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
        def contains(root: TreeNode, p: TreeNode): Boolean = {
            if (root == null) {
                false
            } else if (root.value == p.value) {
                true
            } else {
                contains(root.left, p) || contains(root.right, p)
            }
        }

        if (root == null) {
            null
        } else {
            val lResult = lowestCommonAncestor(root.left, p, q)
            val rResult = lowestCommonAncestor(root.right, p, q)

            if (lResult != null) {
                lResult
            } else if (rResult != null) {
                rResult
            } else if (contains(root, p) && contains(root, q)) {
                root
            } else {
                null
            }
        }
    }
}
