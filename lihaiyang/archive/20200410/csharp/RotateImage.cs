// RotateImage.cs
// Author: hyan23
// 2019.10.24
// https://leetcode.com/problems/rotate-image/

/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
Example 1:
Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */

// Runtime: 252 ms, faster than 78.45% of C# online submissions for Rotate Image.
// Memory Usage: 29.5 MB, less than 10.00% of C# online submissions for Rotate Image.

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
            int[][] m1 = new int[][]
            {
                new int[]{ 1, 2, 3 },
                new int[]{ 4, 5, 6 },
                new int[]{ 7, 8, 9 }
            };
            Rotate(m1);
            PrintMatrix(m1);
            Console.WriteLine();

            int[][] m2 = new int[][]
            {
                new int[]{ 5, 1, 9, 11 },
                new int[]{ 2, 4, 8, 10 },
                new int[]{ 13, 3, 6, 7 },
                new int[]{ 15, 14, 12, 16 }
            };
            Rotate(m2);
            PrintMatrix(m2);
            Console.WriteLine();
        }

        private void PrintMatrix(int[][] matrix)
        {
            foreach (var arr in matrix)
            {
                Console.WriteLine(string.Join(" ", arr));
            }
        }

        public void Rotate(int[][] matrix)
        {
            int n = matrix.Length;
            for (int i = 0; i < n / 2; i++)
            {
                for (int j = i; j < n - 1 - i; j++)
                {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = t;
                }
            }
        }
    }
}
