// DiameterOfBinaryTree.cs
// Author: hyan23
// 2020.04.12
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3293/

// Runtime: 96 ms
// Memory Usage: 25.8 MB

using System;

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

        public int DiameterOfBinaryTree(TreeNode root)
        {
            int diameter = 0;
            SubTreeDepth(root, ref diameter);
            return diameter;
        }

        private int SubTreeDepth(TreeNode root, ref int diameter)
        {
            if (root == null)
            {
                return 0;
            }
            int leftSubTreeDepth = SubTreeDepth(root.left, ref diameter);
            int rightSubTreeDepth = SubTreeDepth(root.right, ref diameter);
            diameter = Math.Max(diameter, leftSubTreeDepth + rightSubTreeDepth);
            return 1 + Math.Max(leftSubTreeDepth, rightSubTreeDepth);
        }
    }
}
