// BinaryTreeInorderTraversal.cs
// Author: hyan23
// 2020.04.16
// https://leetcode.com/problems/binary-tree-inorder-traversal/

// Runtime: 232 ms, faster than 91.86% of C# online submissions for Binary Tree Inorder Traversal.
// Memory Usage: 30.1 MB, less than 16.67% of C# online submissions for Binary Tree Inorder Traversal.

using System.Collections.Generic;

namespace csharp
{
    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public class Program
    {
        public static void Main()
        {
            new Program().Test();
        }

        public void Test()
        {
        }

        public IList<int> InorderTraversal(TreeNode root)
        {
            if (root == null)
            {
                return new List<int>();
            }

            Stack<TreeNode> sta = new Stack<TreeNode>();
            sta.Push(root);
            HashSet<TreeNode> visited = new HashSet<TreeNode>();
            IList<int> result = new List<int>();

            while (sta.Count > 0)
            {
                TreeNode top = sta.Peek();
                if (top.left != null && !visited.Contains(top.left))
                {
                    sta.Push(top.left);
                    visited.Add(top.left);
                }
                else
                {
                    sta.Pop();
                    result.Add(top.val);
                    if (top.right != null)
                    {
                        sta.Push(top.right);
                    }
                }
            }
            return result;
        }
    }
}
