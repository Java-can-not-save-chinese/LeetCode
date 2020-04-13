// PermutationsII.cs
// Author: hyan23
// 2019.10.22
// https://leetcode.com/problems/permutations-ii/

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
Example:
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

// Runtime: 260 ms, faster than 83.97% of C# online submissions for Permutations II.
// Memory Usage: 32.2 MB, less than 33.33% of C# online submissions for Permutations II.

using System;
using System.Collections.Generic;
using System.Diagnostics;
#pragma warning disable
using System.IO;
#pragma warning restore
using System.Linq;

namespace csharp
{
    public class Program
    {
        public static void Main()
        {
            Stopwatch watch = new Stopwatch();
            watch.Start();

            var @out = Console.Out;
            //Console.SetOut(TextWriter.Null);
            new Program().Test();
            Console.SetOut(@out);

            watch.Stop();
            Console.WriteLine($"Runtime: {watch.ElapsedMilliseconds} ms");
        }

        public void Test()
        {
            PrintPermutations(new int[] { 1, 1, 2 });
            Console.WriteLine();
            PrintPermutations(new int[] { });
            Console.WriteLine();
            PrintPermutations(new int[] { 1 });
            Console.WriteLine();
            PrintPermutations(new int[] { 1, 3, 4, 3 });
            Console.WriteLine();
            PrintPermutations(new int[] { 2, 2, 1, 1 });
            Console.WriteLine();
            //PrintPermutations(new int[] { 1, 1, 0, 0, 1, -1, -1, 1 });
        }

        private void PrintPermutations(int[] nums)
        {
            foreach (var permutation in PermuteUnique(nums))
            {
                Console.WriteLine(string.Join(", ", permutation));
            }
        }

        public IList<IList<int>> PermuteUnique(int[] nums)
        {
            List<IList<int>> permutations = new List<IList<int>>();
            if (nums.Length > 0)
            {
                Array.Sort(nums);
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
                if (!visited[i] && (i == 0 || nums[i] != nums[i - 1] || visited[i - 1]))
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
