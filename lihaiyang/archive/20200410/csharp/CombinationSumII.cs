// CombinationSumII.cs
// Author: hyan23
// 2019.10.20
// https://leetcode.com/problems/combination-sum-ii/

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */

/*
 * Runtime: 308 ms, faster than 10.21% of C# online submissions for Combination Sum II.
 * Memory Usage: 32.2 MB, less than 100.00% of C# online submissions for Combination Sum II.
*/

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
            SolveAndShow(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
            SolveAndShow(new int[] { 2, 5, 2, 1, 2 }, 5);
        }

        public void SolveAndShow(int[] candidates, int target)
        {
            foreach (var combo in CombinationSum2(candidates, target))
            {
                Console.WriteLine(string.Join(", ", combo));
            }
            Console.WriteLine();
        }

        class Cmp : IEqualityComparer<IList<int>>
        {
            public bool Equals(IList<int> x, IList<int> y)
            {
                return x.SequenceEqual(y);
            }

            public int GetHashCode(IList<int> obj)
            {
                return 0;
            }
        }

        public IList<IList<int>> CombinationSum2(int[] candidates, int target)
        {
            List<IList<int>> results = new List<IList<int>>();
            Helper(candidates, 0, target, new List<int>(), results);
            return results.Select(x => x.OrderBy(y => y).ToList()).Distinct(new Cmp()).ToList();
        }

        public void Helper(int[] candidates, int index, int target, List<int> combo, IList<IList<int>> results)
        {
            if (target == 0)
            {
                results.Add(combo.ToList());
            }
            if (target > 0)
            {
                for (int i = index; i < candidates.Length; i++)
                {
                    int cand = candidates[i];
                    combo.Add(cand);
                    Helper(candidates, i + 1, target - cand, combo, results);
                    combo.Remove(cand);
                }
            }
        }
    }
}
