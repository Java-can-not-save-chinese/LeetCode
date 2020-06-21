// CountingElements.cs
// Author: hyan23
// 2020.04.11
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/

// Runtime: 92 ms
// Memory Usage: 24.1 MB

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

        public int CountElements(int[] arr)
        {
            HashSet<int> hs = new HashSet<int>(arr);
            return arr.Count(x => hs.Contains(x + 1));
        }
    }
}
