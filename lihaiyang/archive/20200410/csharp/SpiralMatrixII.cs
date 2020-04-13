// SpiralMatrixII.cs
// Author: hyan23
// 2019.10.28
// https://leetcode.com/problems/spiral-matrix-ii/

/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
Example:
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */

// Runtime: 212 ms, faster than 83.00% of C# online submissions for Spiral Matrix II.
// Memory Usage: 25.1 MB, less than 25.00% of C# online submissions for Spiral Matrix II.

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

        public int[][] GenerateMatrix(int n)
        {
            int[][] mat = new int[n][];
            for (int i = 0; i < n; i++)
            {
                mat[i] = new int[n];
            }

            int layer = (int)Math.Ceiling(n / 2.0);
            int counter = 0;

            for (int i = 0; i < layer; i++)
            {
                for (int j = i; j < n - i; j++)
                {
                    mat[i][j] = counter++;
                }
                for (int j = i + 1; j < n - i - 1; j++)
                {
                    mat[j][n - 1 - i] = counter++;
                }
                if (i < n / 2)
                {
                    for (int j = i; j < n - i; j++)
                    {
                        mat[n - 1 - i][n - 1 - j] = counter++;
                    }
                }
                if (i < n / 2)
                {
                    for (int j = i + 1; j < n - i - 1; j++)
                    {
                        mat[n - 1 - j][i] = counter++;
                    }
                }
            }

            return mat;
        }
    }
}
