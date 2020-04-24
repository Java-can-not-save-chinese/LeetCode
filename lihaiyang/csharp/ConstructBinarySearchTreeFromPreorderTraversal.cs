// ConstructBinarySearchTreeFromPreorderTraversal.cs
// Author: hyan23
// 2020.04.20
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3305/

// Runtime: 88 ms
// Memory Usage: 24.3 MB

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

        public TreeNode BstFromPreorder(int[] preorder)
        {
            if (preorder.Length == 0)
            {
                return null;
            }

            TreeNode root = new TreeNode(preorder[0]);
            TreeNode cur = root;
            Stack<TreeNode> path = new Stack<TreeNode>();

            for (int i = 1; i < preorder.Length; i++)
            {
                int val = preorder[i];
                if (val < cur.val)
                {
                    cur.left = new TreeNode(val);
                    path.Push(cur);
                    cur = cur.left;
                }
                else
                {
                    while (path.Count > 0 && path.Peek().val < val)
                    {
                        cur = path.Pop();
                    }
                    cur.right = new TreeNode(val);
                    cur = cur.right;
                }
            }

            return root;
        }
    }
}
