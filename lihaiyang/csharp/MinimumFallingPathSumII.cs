// MinimumFallingPathSumII.cs
// Author: hyan23
// 2020.04.27
// https://leetcode.com/problems/minimum-falling-path-sum-ii/

// Runtime: 768 ms, faster than 7.89% of C# online submissions for Minimum Falling Path Sum II.
// Memory Usage: 30.3 MB, less than 100.00% of C# online submissions for Minimum Falling Path Sum II.

using System;
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

        public int MinFallingPathSum(int[][] A)
        {
            int n = A.Length;
            int? min = null;

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (i > 0)
                    {
                        A[i][j] += A[i - 1].Where((x, y) => y != j).Min();
                    }
                    if (i == n - 1)
                    {
                        min = min.HasValue ? Math.Min(min.Value, A[i][j]) : A[i][j];
                    }
                }
            }

            return min ?? 0;
        }
    }
}
