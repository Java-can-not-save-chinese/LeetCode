// Implement_strStr.cs
// Author: hyan23
// 2019.11.12
// https://leetcode.com/problems/implement-strstr/

/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/

// Runtime: 84 ms, faster than 39.80% of C# online submissions for Implement strStr().
// Memory Usage: 22.9 MB, less than 6.67% of C# online submissions for Implement strStr().

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
            Console.WriteLine(StrStr("hello", "ll"));
            Console.WriteLine(StrStr("aaaaa", "bba"));

            Console.WriteLine(StrStr("a", ""));
            Console.WriteLine(StrStr("", "a"));
            Console.WriteLine(StrStr("", ""));
        }

        // TODO: KMP
        public int StrStr(string haystack, string needle)
        {
            return haystack.IndexOf(needle);
        }
    }
}
