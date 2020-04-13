// WildcardMatching.cs
// Author: hyan23
// 2019.10.20
// https://leetcode.com/problems/wildcard-matching/

/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
 */

// Runtime: 112 ms, faster than 54.26% of C# online submissions for Wildcard Matching.
// Memory Usage: 31 MB, less than 100.00% of C# online submissions for Wildcard Matching.

using System;
using System.Diagnostics;
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
            Stopwatch watch = new Stopwatch();
            watch.Start();

            Console.WriteLine(IsMatch("aa", "a"));
            Console.WriteLine(IsMatch("aa", "*"));
            Console.WriteLine(IsMatch("cb", "?a"));
            Console.WriteLine(IsMatch("adceb", "*a*b"));
            Console.WriteLine(IsMatch("acdcb", "a*c?b"));
            Console.WriteLine(IsMatch("acdcb", "*a"));
            Console.WriteLine(IsMatch("", "*"));

            watch.Stop();
            Console.WriteLine($"Runtime: {watch.ElapsedMilliseconds} ms");
        }

        public bool IsMatch(string s, string p)
        {
            bool?[,] notes = new bool?[s.Length, p.Length];
            return dp(notes, s, p, 0, 0);
        }

        public bool dp(bool?[,] notes, string s, string p, int i, int j)
        {
            if (i == s.Length)
            {
                return p.Substring(j).All(x => x == '*');
            }
            if (j == p.Length)
            {
                return i == s.Length;
            }
            if (notes[i, j].HasValue)
            {
                return notes[i, j].Value;
            }
            if (p[j] == '*')
            {
                return (bool)(notes[i, j] = dp(notes, s, p, i, j + 1) ||
                    dp(notes, s, p, i + 1, j));
            }
            else if (p[j] == '?')
            {
                return (bool)(notes[i, j] = dp(notes, s, p, i + 1, j + 1));
            }
            else
            {
                return (bool)(notes[i, j] = s[i] == p[j] && dp(notes, s, p, i + 1, j + 1));
            }
        }
    }
}
