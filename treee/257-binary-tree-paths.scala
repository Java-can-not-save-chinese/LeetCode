/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def binaryTreePaths(root: TreeNode): List[String] = {
        val r: List[String] = {
            if (root == null) {
                List()
            } else if (root.left == null && root.right == null) {
                List(root.value.toString)
            } else if (root.left == null) {
                binaryTreePaths(root.right)
            } else if (root.right == null) {
                binaryTreePaths(root.left)
            } else {
                binaryTreePaths(root.left) ++ binaryTreePaths(root.right)
            }
        }

        if (root == null || root.left == null && root.right == null) {
            r
        } else {
            r.map(x => root.value.toString ++ "->" ++ x)
        }
    }
}