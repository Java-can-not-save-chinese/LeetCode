package week06;


/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/10 16:07
 */
public class LeetCode_450 {


    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        //1 找到被删除的节点
        TreeNode node = node(root, key);
        if (node == null) {
            return root;
        }
        //2 父节点
        TreeNode parent = null;
        //3 度为2的节点，找到前驱节点,用前驱节点的值代替根节点的值，node指向前驱节点，删除
        if (node.left != null && node.right != null) {
            TreeNode predecessor = predecessor(node.left);
            parent = parent(root, predecessor);
            node.val = predecessor.val;
            node = predecessor;
        }
        if (parent == null) {
            parent = parent(root, node);
        }
        //4 判断node节点类型
        if (node.left == null && node.right == null) {
            //4.1 叶子节点直接删除
            if (parent == node) {
                //特殊情况当前节点是根节点
                root = null;
            } else if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else {
            //4.2 度为1的节点
            //删除节点的左子树不为空，判断该节点是父节点的左节点还是右节点并用删除节点的左子树替换
            if (node.left != null) {
                //根节点
                if (parent == node) {
                    root = root.left;
                } else if (parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            }
            //删除节点的右子树不为空，判断该节点是父亲节点的左节点还是右节点并用删除节点的右子树替换
            else {
                if (parent == node) {
                    root = root.right;
                } else if (parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            }
        }
        //5 返回root节点
        return root;
    }

    /**
     * 父节点
     */
    private static TreeNode parent(TreeNode root, TreeNode node) {
        if (root.left == node || root.right == node) {
            return root;
        }

        if (root.val > node.val) {
            return parent(root.left, node);
        } else if (root.val < node.val) {
            return parent(root.right, node);
        } else {
            return root;
        }

    }

    /**
     * 当前节点
     */
    private static TreeNode node(TreeNode node, int key) {
        while (node != null) {
            if (key > node.val) {
                node = node.right;
            } else if (key < node.val) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     * 前驱节点
     */
    private static TreeNode predecessor(TreeNode node) {
        if (node.right != null) {
            return predecessor(node.right);
        }
        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
