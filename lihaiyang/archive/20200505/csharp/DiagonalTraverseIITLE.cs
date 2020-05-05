// DiagonalTraverseIITLE.cs
// Author: hyan23
// 2020.04.28
// https://leetcode.com/contest/weekly-contest-186/problems/diagonal-traverse-ii/

// TLE

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

        public int[] FindDiagonalOrder(IList<IList<int>> nums)
        {
            if (nums.Count == 0)
            {
                return new int[0];
            }

            List<int> results = new List<int>();

            for (int i = 0; i < nums.Count; i++)
            {
                for (int j = i, k = 0; j >= 0; j--, k++)
                {
                    if (nums[j].Count > k)
                    {
                        results.Add(nums[j][k]);
                    }
                }
            }

            int maxRowLen = nums.Select(x => x.Count).Max();
            for (int i = 1; i < maxRowLen; i++)
            {
                for (int j = nums.Count - 1, k = i; j >= 0; j--, k++)
                {
                    if (nums[j].Count > k)
                    {
                        results.Add(nums[j][k]);
                    }
                }
            }

            return results.ToArray();
        }
    }
}
