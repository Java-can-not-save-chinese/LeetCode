// UniquePathsII.cs
// Author: hyan23
// 2019.10.29
// https://leetcode.com/problems/unique-paths-ii/

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.
Note: m and n will be at most 100.
Example 1:
Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */

// Runtime: 96 ms, faster than 75.29% of C# online submissions for Unique Paths II.
// Memory Usage: 23.9 MB, less than 20.00% of C# online submissions for Unique Paths II.

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
            Console.WriteLine(UniquePathsWithObstacles(
                new int[][]
                {
                    new int[] { 0, 0, 0 },
                    new int[] { 0, 1, 0 },
                    new int[] { 0, 0, 0 }
                }));
        }

        public int UniquePathsWithObstacles(int[][] obstacleGrid)
        {
            int m = obstacleGrid.Length;
            // Trace.Assert(m != 0);
            int n = obstacleGrid[0].Length;
            // Trace.Assert(n != 0);

            bool obstacle = obstacleGrid[0][0] == 1;
            for (int i = 1; i < n; i++)
            {
                obstacle = obstacle || obstacleGrid[0][i] == 1;
                obstacleGrid[0][i] = obstacle ? 0 : 1;
            }
            obstacle = obstacleGrid[0][0] == 1;
            for (int i = 1; i < m; i++)
            {
                obstacle = obstacle || obstacleGrid[i][0] == 1;
                obstacleGrid[i][0] = obstacle ? 0 : 1;
            }
            obstacleGrid[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

            for (int i = 1; i < m; i++)
            {
                for (int j = 1; j < n; j++)
                {
                    obstacleGrid[i][j] = obstacleGrid[i][j] == 0 ?
                        obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1] :
                        0;
                }
            }

            return obstacleGrid[m - 1][n - 1];
        }
    }
}
