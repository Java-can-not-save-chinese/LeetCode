/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    import scala.collection.mutable.ListBuffer
    def kthSmallest(root: TreeNode, k: Int): Int = {
        def inorder(root: TreeNode, l: ListBuffer[Int], k: Int): ListBuffer[Int] = {
            if (root == null || l.size == k) {
                l
            } else {
                var r = inorder(root.left, l, k)
                if (r.size < k) {
                    r = r :+ root.value
                }
                inorder(root.right, r, k)
            }
        }

        val r = inorder(root, ListBuffer(), k)
        r.last
    }
}
