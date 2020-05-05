// MaximumLengthOfRepeatedSubarray.cs
// Author: hyan23
// 2020.04.27
// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

// Runtime: 260 ms, faster than 13.33% of C# online submissions for Maximum Length of Repeated Subarray.
// Memory Usage: 47.6 MB, less than 33.33% of C# online submissions for Maximum Length of Repeated Subarray.

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

        public int FindLength(int[] A, int[] B)
        {
            int m = A.Length, n = B.Length;
            int[,] dp = new int[m + 1, n + 1];

            for (int i = 0; i < m; i++)
            {
                dp[i, n] = 0;
            }
            for (int i = 0; i < n; i++)
            {
                dp[m, i] = 0;
            }

            int result = 0;
            for (int i = m - 1; i >= 0; i--)
            {
                for (int j = n - 1; j >= 0; j--)
                {
                    dp[i, j] = A[i] == B[j] ? 1 + dp[i + 1, j + 1] : 0;
                    result = Math.Max(result, dp[i, j]);
                }
            }

            return result;
        }
    }
}
