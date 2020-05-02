// CheckIfAStringIsAValidSequence.cs
// Author: hyan23
// 2020.04.30
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/

// Runtime: 140 ms
// Memory Usage: 36.1 MB

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

        public bool IsValidSequence(TreeNode root, int[] arr)
        {
            if (root == null)
            {
                return arr.Length == 0;
            }
            return Helper(root, arr, 0);
        }

        private bool Helper(TreeNode root, int[] arr, int idx)
        {
            if (idx == arr.Length)
            {
                return false;
            }

            bool result = root.val == arr[idx];
            if (root.left == null && root.right == null)
            {
                result &= idx == arr.Length - 1;
            }
            else
            {
                bool tmp = false;
                if (root.left != null)
                {
                    tmp |= Helper(root.left, arr, idx + 1);
                }
                if (root.right != null)
                {
                    tmp |= Helper(root.right, arr, idx + 1);
                }
                result &= tmp;
            }

            return result;
        }
    }
}
