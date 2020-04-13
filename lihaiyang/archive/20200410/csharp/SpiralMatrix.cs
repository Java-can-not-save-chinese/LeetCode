// SpiralMatrix.cs
// Author: hyan23
// 2019.10.25
// https://leetcode.com/problems/spiral-matrix/

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

// Runtime: 248 ms, faster than 71.53% of C# online submissions for Spiral Matrix.
// Memory Usage: 29 MB, less than 25.00% of C# online submissions for Spiral Matrix.

using System;
using System.Collections.Generic;

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
            IList<int> result = SpiralOrder(new int[][]
            {
                new int[]{ 1, 2, 3 },
                new int[]{ 4, 5, 6 },
                new int[]{ 7, 8, 9 }
            });
            Console.WriteLine(string.Join(", ", result));

            result = SpiralOrder(new int[][]
            {
                new int[]{ 1, 2, 3, 4 },
                new int[]{ 5, 6, 7, 8 },
                new int[]{ 9, 10, 11, 12 }
            });
            Console.WriteLine(string.Join(", ", result));

            result = SpiralOrder(new int[][]
            {
                new int[]{ 1 }
            });
            Console.WriteLine(string.Join(", ", result));

            result = SpiralOrder(new int[][]
            {
                new int[]{ }
            });
            Console.WriteLine(string.Join(", ", result));

            result = SpiralOrder(new int[][]
            {
                new int[]{ 1, 2, 3 },
                new int[]{ 4, 5, 6 },
                new int[]{ 7, 8, 9 },
                new int[]{ 10, 11, 12 }
            });
            Console.WriteLine(string.Join(", ", result));

            result = SpiralOrder(new int[][]
            {
                new int[]{ 7 },
                new int[]{ 9 },
                new int[]{ 6 }
            });
            Console.WriteLine(string.Join(", ", result));

            result = SpiralOrder(new int[][]
            {
                new int[]{ 1, 2, 3 }
            });
            Console.WriteLine(string.Join(", ", result));
        }

        public IList<int> SpiralOrder(int[][] matrix)
        {
            List<int> result = new List<int>();
            int m = matrix.Length;
            if (m == 0)
            {
                return result;
            }
            int n = matrix[0].Length;
            int minDim = Math.Min(m, n);
            int layer = (int)Math.Ceiling(minDim / 2.0);

            for (int i = 0; i < layer; i++)
            {
                for (int j = i; j < n - i; j++)
                {
                    result.Add(matrix[i][j]);
                }
                for (int j = i + 1; j < m - i - 1; j++)
                {
                    result.Add(matrix[j][n - 1 - i]);
                }
                if (i < m / 2)
                {
                    for (int j = i; j < n - i; j++)
                    {
                        result.Add(matrix[m - 1 - i][n - 1 - j]);
                    }
                }
                if (i < n / 2)
                {
                    for (int j = i + 1; j < m - i - 1; j++)
                    {
                        result.Add(matrix[m - 1 - j][i]);
                    }
                }
            }
            return result;
        }
    }
}
