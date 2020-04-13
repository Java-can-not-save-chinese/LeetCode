// MinimumPathSum.cs
// Author: hyan23
// 2019.10.29
// https://leetcode.com/problems/minimum-path-sum/

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

// Runtime: 116 ms, faster than 15.84% of C# online submissions for Minimum Path Sum.
// Memory Usage: 25.3 MB, less than 100.00% of C# online submissions for Minimum Path Sum.

using System;

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

        public int MinPathSum(int[][] grid)
        {
            int m = grid.Length;
            // Trace.Assert(m != 0);
            int n = grid[0].Length;
            // Trace.Assert(n != 0);

            for (int i = 1; i < n; i++)
            {
                grid[0][i] += grid[0][i - 1];
            }
            for (int i = 1; i < m; i++)
            {
                grid[i][0] += grid[i - 1][0];
            }

            for (int i = 1; i < m; i++)
            {
                for (int j = 1; j < n; j++)
                {
                    grid[i][j] += Math.Min(grid[i - 1][j], grid[i][j - 1]);
                }
            }

            return grid[m - 1][n - 1];
        }
    }
}
