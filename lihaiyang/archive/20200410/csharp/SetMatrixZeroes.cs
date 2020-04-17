// SetMatrixZeroes.cs
// Author: hyan23
// 2019.11.12
// https://leetcode.com/problems/set-matrix-zeroes/

/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

// Runtime: 296 ms, faster than 13.04% of C# online submissions for Set Matrix Zeroes.
// Memory Usage: 33 MB, less than 12.50% of C# online submissions for Set Matrix Zeroes.

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
            int[][] matrix = new int[][]
            {
                new int[] { 1, 1, 1 },
                new int[] { 1, 0, 1 },
                new int[] { 1, 1, 1 }
            };
            SetZeroes(matrix);
            PrintMatrix(matrix);

            matrix = new int[][]
            {
                new int[] { 0, 1, 2, 0 },
                new int[] { 3, 4, 5, 2 },
                new int[] { 1, 3, 1, 5 }
            };
            SetZeroes(matrix);
            PrintMatrix(matrix);
        }

        private void PrintMatrix(int[][] matrix)
        {
            foreach (var arr in matrix)
            {
                Console.WriteLine(string.Join(" ", arr));
            }
        }

        public void SetZeroes(int[][] matrix)
        {
            int row = -1;
            for (int i = 0; i < matrix.Length; i++)
            {
                int zeroCount = 0;
                for (int j = 0; j < matrix[i].Length; j++)
                {
                    if (matrix[i][j] == 0)
                    {
                        if (row == -1)
                        {
                            row = i;
                            for (int k = 0; k < matrix[row].Length; k++)
                            {
                                if (matrix[row][k] != 0)
                                {
                                    matrix[row][k] = -1;
                                }
                            }
                        }
                        matrix[row][j] = 1;
                        zeroCount++;
                    }
                }
                if (i != row && zeroCount > 0)
                {
                    for (int j = 0; j < matrix[i].Length; j++)
                    {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (row != -1)
            {
                for (int i = 0; i < matrix[row].Length; i++)
                {
                    if (matrix[row][i] != -1)
                    {
                        for (int j = 0; j < matrix.Length; j++)
                        {
                            matrix[j][i] = 0;
                        }
                    }
                }
                for (int i = 0; i < matrix[row].Length; i++)
                {
                    matrix[row][i] = 0;
                }
            }
        }
    }
}
