// Permutations.cs
// Author: hyan23
// 2019.10.22
// https://leetcode.com/problems/permutations/

/*
 * Given a collection of distinct integers, return all possible permutations.
Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

// Runtime: 248 ms, faster than 92.43% of C# online submissions for Permutations.
// Memory Usage: 30.7 MB, less than 50.00% of C# online submissions for Permutations.

using System;
using System.Collections.Generic;
using System.Linq;

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
            PrintPermutations(new int[] { 1, 2, 3 });
            Console.WriteLine();
            PrintPermutations(new int[] { });
            Console.WriteLine();
            PrintPermutations(new int[] { 1 });
            Console.WriteLine();
            PrintPermutations(new int[] { 1, 3, 4, 5 });
        }

        private void PrintPermutations(int[] nums)
        {
            foreach (var permutation in Permute(nums))
            {
                Console.WriteLine(string.Join(", ", permutation));
            }
        }

        public IList<IList<int>> Permute(int[] nums)
        {
            List<IList<int>> permutations = new List<IList<int>>();
            if (nums.Length > 0)
            {
                bool[] visited = new bool[nums.Length];
                int[] permutation = new int[nums.Length];
                Helper(permutations, permutation, 0, nums, visited);
            }
            return permutations;
        }

        private void Helper(IList<IList<int>> permutations, int[] permutation, int index, int[] nums, bool[] visited)
        {
            for (int i = 0; i < nums.Length; i++)
            {
                if (!visited[i])
                {
                    visited[i] = true;
                    permutation[index] = nums[i];
                    Helper(permutations, permutation, index + 1, nums, visited);
                    visited[i] = false;
                }
            }
            if (index == nums.Length)
            {
                permutations.Add(permutation.ToList());
            }
        }
    }
}
