// Subsets.cs
// Author: hyan23
// 2019.11.20
// https://leetcode.com/problems/subsets/

/* 
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

// Runtime: 248 ms, faster than 71.02% of C# online submissions for Subsets.
// Memory Usage: 30.1 MB, less than 12.50% of C# online submissions for Subsets.

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
        }

        public IList<IList<int>> Subsets(int[] nums)
        {
            List<IList<int>> results = new List<IList<int>>() { new List<int>() };
            for (int i = 1; i <= nums.Length; i++)
            {
                results.AddRange(Combine(nums.Length, i));
            }
            foreach (var set in results)
            {
                for (int i = 0; i < set.Count; i++)
                {
                    set[i] = nums[set[i] - 1];
                }
            }
            return results;
        }

        public IList<IList<int>> Combine(int n, int k)
        {
            IList<IList<int>> results = new List<IList<int>>();
            for (int i = 1; i <= n - k + 1; i++)
            {
                Helper(results, new List<int>() { i }, i + 1, n, k);
            }
            return results;
        }

        private void Helper(IList<IList<int>> results, IList<int> combo, int m, int n, int k)
        {
            if (combo.Count < k)
            {
                for (int i = m; i <= n - (k - combo.Count) + 1; i++)
                {
                    combo.Add(i);
                    Helper(results, combo, i + 1, n, k);
                    combo.Remove(i);
                }
            }
            else
            {
                results.Add(combo.ToList());
            }
        }
    }
}
