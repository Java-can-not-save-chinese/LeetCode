// LongestConsecutiveSequence.cs
// Author: hyan23
// 2020.04.27
// https://leetcode.com/problems/longest-consecutive-sequence/

// Runtime: 124 ms, faster than 20.29% of C# online submissions for Longest Consecutive Sequence.
// Memory Usage: 25.1 MB, less than 25.00% of C# online submissions for Longest Consecutive Sequence.

using System;
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
            Console.WriteLine(LongestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
        }

        public int LongestConsecutive(int[] nums)
        {
            int result = 0;

            HashSet<int> hs = new HashSet<int>(nums);
            while (hs.Count > 0)
            {
                int v = hs.First();
                int length = 0;

                Queue<int> q = new Queue<int>();
                q.Enqueue(v);
                while (q.Count > 0)
                {
                    int n = q.Dequeue();
                    hs.Remove(n);
                    length++;

                    if (hs.Contains(n + 1))
                    {
                        q.Enqueue(n + 1);
                    }
                    if (hs.Contains(n - 1))
                    {
                        q.Enqueue(n - 1);
                    }
                }

                result = Math.Max(result, length);
            }

            return result;
        }
    }
}
