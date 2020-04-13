// CombinationSum.cs
// Author: hyan23
// 2019.10.20
// https://leetcode.com/problems/combination-sum/

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */

/*
Runtime: 296 ms, faster than 12.98% of C# online submissions for Combination Sum.
Memory Usage: 31.4 MB, less than 25.00% of C# online submissions for Combination Sum.
 */

using System;
using System.Collections.Generic;
using System.Diagnostics;

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
            Stopwatch watch = new Stopwatch();
            watch.Start();

            foreach (var combo in CombinationSum(new int[] { 2, 3, 6, 7 }, 7))
            {
                Console.WriteLine(string.Join(",", combo));
            }
            Console.WriteLine();
            foreach (var combo in CombinationSum(new int[] { 2, 3, 5 }, 8))
            {
                Console.WriteLine(string.Join(",", combo));
            }
            Console.WriteLine();
            foreach (var combo in CombinationSum(new int[] { 6, 8, 12, 5, 9, 3, 4, 11 }, 31))
            {
                //Console.WriteLine(string.Join(",", combo));
            }

            watch.Stop();
            Console.WriteLine($"{watch.ElapsedMilliseconds}ms");
        }

        public IList<IList<int>> CombinationSum(int[] candidates, int target)
        {
            List<IList<int>> results = new List<IList<int>>();
            Helper(candidates, 0, target, new List<int>(), results);
            return results;
        }

        public void Helper(int[] candidates, int index, int target, List<int> combo, List<IList<int>> results)
        {
            if (index > candidates.Length - 1)
            {
                return;
            }
            if (target > 0)
            {
                // 不允许选取上次选取元素之前的元素，因为那个元素必然已被其他序列选过
                // 而那个序列有机会选择本序列所有元素而产生重复
                for (int i = index; i < candidates.Length; i++)
                {
                    List<int> combo2 = new List<int>(combo);
                    combo2.Add(candidates[i]);
                    Helper(candidates, i, target - candidates[i], combo2, results);
                }
            }
            else if (target == 0)
            {
                results.Add(combo);
            }
        }
    }
}
