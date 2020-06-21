// RotateArray.cs
// Author: hyan23
// 2020.05.05
// https://leetcode.com/problems/rotate-array/

// ExtraMem:
// Runtime: 252 ms, faster than 33.21% of C# online submissions for Rotate Array.
// Memory Usage: 32.4 MB, less than 9.09% of C# online submissions for Rotate Array.

// Reversions (Linq):
// Runtime: 264 ms, faster than 16.05% of C# online submissions for Rotate Array.
// Memory Usage: 32.9 MB, less than 9.09% of C# online submissions for Rotate Array.

// Reversions (Array):
// Runtime: 240 ms, faster than 87.01% of C# online submissions for Rotate Array.
// Memory Usage: 32.3 MB, less than 9.09% of C# online submissions for Rotate Array.

// InPlace:
// Runtime: 656 ms, faster than 5.03% of C# online submissions for Rotate Array.
// Memory Usage: 32.1 MB, less than 9.09% of C# online submissions for Rotate Array.

using System;
#pragma warning disable IDE0005
#pragma warning restore

namespace csharp
{
    public class Program
    {
        public static void Main()
        {
            new Program().Test();
        }

        public void Test()
        {
        }

        public void Rotate(int[] nums, int k)
        {
            if (nums.Length > 0)
            {
                int steps = k % nums.Length;
                if (steps > 0)
                {
                    ExtraMem(nums, steps);
                    Reversions(nums, steps);
                    InPlace(nums, steps);
                }
            }
        }

        private void ExtraMem(int[] nums, int k)
        {
            int[] tmp = new int[nums.Length];
            nums.CopyTo(tmp, 0);
            for (int i = 0; i < k; i++)
            {
                nums[i] = tmp[nums.Length - k + i];
            }
            for (int i = 0; i < nums.Length - k; i++)
            {
                nums[k + i] = tmp[i];
            }
        }

        private void Reversions(int[] nums, int k)
        {
            Array.Reverse(nums, 0, nums.Length - k);
            Array.Reverse(nums, nums.Length - k, k);
            Array.Reverse(nums);
            /*
            nums.Take(nums.Length - k).Reverse().
                Concat(nums.TakeLast(k).Reverse()).
                Reverse().
                ToArray().CopyTo(nums, 0);
            */
        }

        private void InPlace(int[] nums, int k)
        {
            for (int i = 0; i < k; i++)
            {
                int last = nums[nums.Length - 1];
                for (int j = nums.Length - 1; j > 0; j--)
                {
                    nums[j] = nums[j - 1];
                }
                nums[0] = last;
            }
        }
    }
}
