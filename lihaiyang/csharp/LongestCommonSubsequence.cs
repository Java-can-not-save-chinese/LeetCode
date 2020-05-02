// LongestCommonSubsequence.cs
// Author: hyan23
// 2020.04.27
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3311/

// Runtime: 120 ms
// Memory Usage: 25.6 MB

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
            Console.WriteLine(LongestCommonSubsequence("abcde", "ace"));
            Console.WriteLine(LongestCommonSubsequence("abc", "abc"));
            Console.WriteLine(LongestCommonSubsequence("abc", "def"));
            Console.WriteLine(LongestCommonSubsequence("dabc", "abc"));
            Console.WriteLine(LongestCommonSubsequence("abc", "dabc"));
            Console.WriteLine(LongestCommonSubsequence("", "dabc"));
            Console.WriteLine(LongestCommonSubsequence("abc", ""));
        }

        public int LongestCommonSubsequence(string text1, string text2)
        {
            int longest = 0;

            int m = text1.Length, n = text2.Length;
            int[,] dp = new int[m + 1, n + 1];
            for (int i = 0; i < m; i++)
            {
                dp[i, n] = 0;
            }
            for (int i = 0; i < n; i++)
            {
                dp[m, i] = 0;
            }

            for (int i = m - 1; i >= 0; i--)
            {
                for (int j = n - 1; j >= 0; j--)
                {
                    dp[i, j] = text1[i] == text2[j] ? 1 + dp[i + 1, j + 1] : Math.Max(dp[i + 1, j], dp[i, j + 1]);
                    longest = Math.Max(longest, dp[i, j]);
                }
            }

            return longest;
        }
    }
}
