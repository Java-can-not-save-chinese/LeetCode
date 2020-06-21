// MinimumFallingPathSum.cs
// Author: hyan23
// 2020.04.27
// https://leetcode.com/problems/minimum-falling-path-sum/

// Runtime: 100 ms, faster than 92.59% of C# online submissions for Minimum Falling Path Sum.
// Memory Usage: 28 MB, less than 100.00% of C# online submissions for Minimum Falling Path Sum.

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
                        int save = A[i][j];
                        A[i][j] = save + A[i - 1][j];
                        int[] dx = new int[] { -1, 1 };
                        for (int k = 0; k < dx.Length; k++)
                        {
                            int x = j + dx[k];
                            if (x >= 0 && x < n)
                            {
                                A[i][j] = Math.Min(A[i][j], save + A[i - 1][x]);
                            }
                        }
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
