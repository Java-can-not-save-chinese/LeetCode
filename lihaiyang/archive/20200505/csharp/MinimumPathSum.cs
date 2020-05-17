// MinimumPathSum.cs
// Author: hyan23
// 2020.04.19
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/

// Time Limit Exceeded
// DP solution in archive/20200410/csharp/MinimumPathSum.cs

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
            if (grid.Length > 0)
            {
                int? min = null;
                Helper(grid, 0, 0, 0, ref min);
                return min.Value;
            }
            else
            {
                return 0;
            }
        }

        private void Helper(int[][] grid, int i, int j, int sum, ref int? min)
        {
            if (i >= 0 && i < grid.Length && j >= 0 && j < grid[i].Length && (!min.HasValue || sum < min.Value))
            {
                sum += grid[i][j];
                if (i == grid.Length - 1 && j == grid[i].Length - 1)
                {
                    min = min.HasValue ? Math.Min(min.Value, sum) : sum;
                    return;
                }
                Helper(grid, i + 1, j, sum, ref min);
                Helper(grid, i, j + 1, sum, ref min);
            }
        }
    }
}
