// NumberOfIslands.cs
// Author: hyan23
// 2020.04.19
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/

// Runtime: 116 ms
// Memory Usage: 28.3 MB

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
        }

        public int NumIslands(char[][] grid)
        {
            if (grid.Length == 0)
            {
                return 0;
            }

            int m = grid.Length, n = grid[0].Length;
            int numIslands = 0;

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (grid[i][j] == '1')
                    {
                        numIslands++;

                        Queue<Tuple<int, int>> q = new Queue<Tuple<int, int>>();
                        q.Enqueue(new Tuple<int, int>(i, j));
                        while (q.Count > 0)
                        {
                            Tuple<int, int> front = q.Dequeue();
                            if (front.Item1 >= 0 && front.Item1 < m &&
                                front.Item2 >= 0 && front.Item2 < n &&
                                grid[front.Item1][front.Item2] == '1')
                            {
                                grid[front.Item1][front.Item2] = '0';
                                q.Enqueue(new Tuple<int, int>(front.Item1 - 1, front.Item2));
                                q.Enqueue(new Tuple<int, int>(front.Item1 + 1, front.Item2));
                                q.Enqueue(new Tuple<int, int>(front.Item1, front.Item2 - 1));
                                q.Enqueue(new Tuple<int, int>(front.Item1, front.Item2 + 1));
                            }
                        }
                    }
                }
            }

            return numIslands;
        }
    }
}
