// FindTheTownJudge.cs
// Author: hyan23
// 2020.05.13
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/

// Runtime: 320 ms
// Memory Usage: 44.4 MB

using System.Collections.Generic;
using System.Linq;

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

        public int FindJudge(int N, int[][] trust)
        {
            if (N == 1)
            {
                return 1;
            }

            Dictionary<int, int> indegrees = new Dictionary<int, int>();
            Dictionary<int, int> outdegrees = new Dictionary<int, int>();

            foreach (var t in trust)
            {
                int from = t[0], to = t[1];
                if (!indegrees.ContainsKey(to))
                {
                    indegrees[to] = 0;
                }
                if (!outdegrees.ContainsKey(from))
                {
                    outdegrees[from] = 0;
                }
                indegrees[to]++;
                outdegrees[from]++;
            }

            var judges = indegrees.Where(x => x.Value == N - 1).Where(x => !outdegrees.ContainsKey(x.Key)).ToList();
            if (judges.Count == 1)
            {
                return judges[0].Key;
            }
            else
            {
                return -1;
            }
        }
    }
}
