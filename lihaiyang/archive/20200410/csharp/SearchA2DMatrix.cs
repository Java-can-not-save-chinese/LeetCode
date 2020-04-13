// SearchA2DMatrix.cs
// Author: hyan23
// 2019.11.15
// https://leetcode.com/problems/search-a-2d-matrix/

/* 
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
*/

// Runtime: 124 ms, faster than 5.92% of C# online submissions for Search a 2D Matrix.
// Memory Usage: 25.2 MB, less than 100.00% of C# online submissions for Search a 2D Matrix.

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
            Console.WriteLine(SearchMatrix(new int[][]
            {
                new int[] { 1, 3, 5, 7  },
                new int[] { 10, 11, 16, 20  },
                new int[] { 23, 30, 34, 50  }
            }, 3));

            Console.WriteLine(SearchMatrix(new int[][]
            {
                new int[] { 1, 3, 5, 7  },
                new int[] { 10, 11, 16, 20  },
                new int[] { 23, 30, 34, 50  }
            }, 13));

            Console.WriteLine(SearchMatrix(new int[][]
            {
                new int[] { 1 }
            }, 1));

            Console.WriteLine(SearchMatrix(new int[][]
            {
                new int[] { 1 }
            }, 2));
        }

        public bool SearchMatrix(int[][] matrix, int target)
        {
            if (matrix.Length == 0)
            {
                return false;
            }

            int m = matrix.Length, n = matrix[0].Length;
            int flatLen = m * n;

            int left = 0, right = flatLen - 1;
            while (left <= right)
            {
                int mid = left + (right - left) / 2;
                int midVal = matrix[mid / n][mid % n];

                if (midVal == target)
                {
                    return true;
                }
                else if (midVal > target)
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }

            return false;
        }
    }
}
