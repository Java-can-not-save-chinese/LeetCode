// MaximalRectangle.cs
// Author: hyan23
// 2020.04.29
// https://leetcode.com/problems/maximal-rectangle/

// Runtime: 156 ms, faster than 6.50% of C# online submissions for Maximal Rectangle.
// Memory Usage: 28.9 MB, less than 100.00% of C# online submissions for Maximal Rectangle.

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

        public int MaximalRectangle(char[][] matrix)
        {
            int m = matrix.Length;
            if (m == 0)
            {
                return 0;
            }
            int n = matrix[0].Length;

            int maxArea = 0;

            char[] lut = new char[256];
            lut['0'] = (char)0;
            lut['1'] = (char)1;

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    matrix[i][j] = lut[matrix[i][j]];
                }
            }

            for (int i = 0; i < m; i++)
            {
                char[] row = (char[])matrix[i].Clone();
                for (int j = i; j < m; j++)
                {
                    int cnt = 0, tmp = 0;
                    for (int k = 0; k < n; k++)
                    {
                        row[k] = (char)(row[k] & matrix[j][k]);
                        tmp = row[k] == (char)1 ? tmp + 1 : 0;
                        cnt = Math.Max(cnt, tmp);
                    }
                    maxArea = Math.Max(maxArea, cnt * (j - i + 1));
                }
            }

            return maxArea;
        }
    }
}
