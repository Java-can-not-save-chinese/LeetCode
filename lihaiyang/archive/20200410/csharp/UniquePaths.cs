// UniquePaths.cs
// Author: hyan23
// 2019.10.29
// https://leetcode.com/problems/unique-paths/

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Above is a 7 x 3 grid. How many possible unique paths are there?
Note: m and n will be at most 100.
Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:
Input: m = 7, n = 3
Output: 28
 */

// Runtime: 36 ms, faster than 95.23% of C# online submissions for Unique Paths.
// Memory Usage: 14.1 MB, less than 9.09% of C# online submissions for Unique Paths.

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
            Console.WriteLine(UniquePaths(3, 2));
            Console.WriteLine(UniquePaths(7, 3));
            Console.WriteLine(UniquePaths(1, 1));
            Console.WriteLine(UniquePaths(23, 12));
        }

        public int UniquePaths(int m, int n)
        {
            int[,] dp = new int[m, n];
            for (int i = 0; i < n; i++)
            {
                dp[0, i] = 1;
            }
            for (int i = 1; i < m; i++)
            {
                dp[i, 0] = 1;
            }
            for (int i = 1; i < m; i++)
            {
                for (int j = 1; j < n; j++)
                {
                    dp[i, j] = dp[i - 1, j] + dp[i, j - 1];
                }
            }
            return dp[m - 1, n - 1];
        }
    }
}
