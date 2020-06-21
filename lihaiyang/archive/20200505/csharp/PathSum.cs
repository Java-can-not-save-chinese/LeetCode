// PathSum.cs
// Author: hyan23
// 2020.04.27
// https://leetcode.com/problems/path-sum/

// Runtime: 100 ms, faster than 54.25% of C# online submissions for Path Sum.
// Memory Usage: 26.1 MB, less than 8.33% of C# online submissions for Path Sum.

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

        public bool HasPathSum(TreeNode root, int sum)
        {
            if (root == null)
            {
                return false;
            }
            return Helper(root, sum);
        }

        public bool Helper(TreeNode root, int sum)
        {
            sum -= root.val;

            if (root.left == null && root.right == null)
            {
                return sum == 0;
            }

            bool result = false;
            if (root.left != null)
            {
                result |= Helper(root.left, sum);
            }
            if (root.right != null)
            {
                result |= Helper(root.right, sum);
            }
            return result;
        }
    }
}
