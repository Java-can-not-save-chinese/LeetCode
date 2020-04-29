// MaximalSquare.cs
// Author: hyan23
// 2020.04.29
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3312/

// Runtime: 148 ms
// Memory Usage: 28.8 MB

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

        public int MaximalSquare(char[][] matrix)
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
                    int edge = Math.Min(cnt, j - i + 1);
                    maxArea = Math.Max(maxArea, edge * edge);
                }
            }

            return maxArea;
        }
    }
}
