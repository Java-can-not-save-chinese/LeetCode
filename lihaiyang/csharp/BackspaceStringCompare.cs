// BackspaceStringCompare.cs
// Author: hyan23
// 2020.04.11
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/

// Runtime: 68 ms
// Memory Usage: 22.4 MB

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
            Console.WriteLine(BackspaceCompare("ab#c", "ad#c"));
            Console.WriteLine(BackspaceCompare("ab##", "c#d#"));
            Console.WriteLine(BackspaceCompare("a##c", "#a#c"));
            Console.WriteLine(BackspaceCompare("a#c", "b"));
        }

        public bool BackspaceCompare(string S, string T)
        {
            int si = S.Length - 1, ti = T.Length - 1;
            int bs1 = 0, bs2 = 0;
            while (true)
            {
                while (si >= 0 && (!(!(S[si] == '#') || ++bs1 <= 0) || (bs1 > 0 ? bs1-- : bs1) > 0)) si--;
                while (ti >= 0 && (!(!(T[ti] == '#') || ++bs2 <= 0) || (bs2 > 0 ? bs2-- : bs2) > 0)) ti--;
                if (si < 0 || ti < 0) return si == ti;
                if (S[si] != T[ti]) return false;
                si--;
                ti--;
            }
        }
    }
}
