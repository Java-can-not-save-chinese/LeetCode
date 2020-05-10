// CousinsInBinaryTree.cs
// Author: hyan23
// 2020.05.07
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/

// Runtime: 96 ms
// Memory Usage: 24.4 MB

using System.Collections.Generic;

namespace csharp
{
    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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

        public bool IsCousins(TreeNode root, int x, int y)
        {
            List<int> path = new List<int>();
            List<int> pathx = new List<int>();
            List<int> pathy = new List<int>();

            FindPaths(root, x, y, path, pathx, pathy);

            return pathx.Count > 0 && pathy.Count > 0 &&
                pathx.Count == pathy.Count &&
                pathx[pathx.Count - 1] != pathy[pathy.Count - 1];
        }

        private void FindPaths(TreeNode root, int x, int y, List<int> path, List<int> pathx, List<int> pathy)
        {
            if (root == null)
            {
                return;
            }
            if (pathx.Count > 0 && pathy.Count > 0)
            {
                return;
            }

            if (root.val == x)
            {
                pathx.Add(-1);
                pathx.AddRange(path);
            }
            if (root.val == y)
            {
                pathy.Add(-1);
                pathy.AddRange(path);
            }

            path.Add(root.val);
            FindPaths(root.left, x, y, path, pathx, pathy);
            FindPaths(root.right, x, y, path, pathx, pathy);
            path.Remove(root.val);
        }
    }
}
