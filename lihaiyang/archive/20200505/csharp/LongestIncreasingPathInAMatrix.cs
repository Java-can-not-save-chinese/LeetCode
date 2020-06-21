// LongestIncreasingPathInAMatrix.cs
// Author: hyan23
// 2020.04.27
// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

// Runtime: 640 ms, faster than 5.00% of C# online submissions for Longest Increasing Path in a Matrix.
// Memory Usage: 45.6 MB, less than 100.00% of C# online submissions for Longest Increasing Path in a Matrix.

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
            Console.WriteLine(LongestIncreasingPath(new int[][] { new int[] { 9, 9, 4 }, new int[] { 6, 6, 8 }, new int[] { 2, 1, 1 } }));
        }

        public int LongestIncreasingPath(int[][] matrix)
        {
            int m = matrix.Length;
            if (m == 0)
            {
                return 0;
            }
            int n = matrix[0].Length;

            Dictionary<Tuple<int, int>, List<Tuple<int, int>>> graph = new Dictionary<Tuple<int, int>, List<Tuple<int, int>>>();
            Dictionary<Tuple<int, int>, int> indegrees = new Dictionary<Tuple<int, int>, int>();
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    int[][] dirs = new int[][] { new int[2] { -1, 0 }, new int[] { 0, 1 }, new int[] { 1, 0 }, new int[] { 0, -1 } };
                    Tuple<int, int> toV = new Tuple<int, int>(i, j);
                    for (int k = 0; k < dirs.Length; k++)
                    {
                        int ii = i + dirs[k][0], ij = j + dirs[k][1];
                        if (ii >= 0 && ii < m && ij >= 0 && ij < n)
                        {
                            if (matrix[i][j] > matrix[ii][ij])
                            {
                                Tuple<int, int> fromV = new Tuple<int, int>(ii, ij);
                                if (!graph.ContainsKey(fromV))
                                {
                                    graph[fromV] = new List<Tuple<int, int>>();
                                }
                                graph[fromV].Add(toV);
                                if (!indegrees.ContainsKey(toV))
                                {
                                    indegrees.Add(toV, 0);
                                }
                                indegrees[toV]++;
                            }
                        }
                    }
                }
            }

            int maxLength = 0;

            Queue<Tuple<int, int>> q = new Queue<Tuple<int, int>>();
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    Tuple<int, int> v = new Tuple<int, int>(i, j);
                    if (!indegrees.ContainsKey(v))
                    {
                        q.Enqueue(v);
                    }
                }
            }

            while (q.Count > 0)
            {
                int cnt = q.Count;
                for (int i = 0; i < cnt; i++)
                {
                    Tuple<int, int> fromV = q.Dequeue();
                    foreach (var toV in graph.ContainsKey(fromV) ? graph[fromV] : new List<Tuple<int, int>>())
                    {
                        indegrees[toV]--;
                        if (indegrees[toV] == 0)
                        {
                            q.Enqueue(toV);
                        }
                    }
                }
                maxLength++;
            }

            return maxLength;
        }
    }
}
