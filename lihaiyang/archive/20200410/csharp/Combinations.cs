// Combinations.cs
// Author: hyan23
// 2019.11.19
// https://leetcode.com/problems/combinations/

/* 
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

// Runtime: 232 ms, faster than 99.11% of C# online submissions for Combinations.
// Memory Usage: 29.4 MB, less than 100.00% of C# online submissions for Combinations.

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
