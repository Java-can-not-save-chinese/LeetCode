// MinimumWindowSubstring.cs
// Author: hyan23
// 2019.11.18
// https://leetcode.com/problems/minimum-window-substring/

/* 
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/

// Runtime: 84 ms, faster than 97.64% of C# online submissions for Minimum Window Substring.
// Memory Usage: 25.2 MB, less than 16.67% of C# online submissions for Minimum Window Substring.

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
            Console.WriteLine(MinWindow("ADOBECODEBANC", "ABC"));
            Console.WriteLine(MinWindow("ADOBECODEBANCD", "ABC"));
            Console.WriteLine(MinWindow("ADOBECODEBANC", "DBC"));
            Console.WriteLine(MinWindow("ADOBECODEBANC", "DBCN"));
            Console.WriteLine(MinWindow("AB", "ABC"));
            Console.WriteLine(MinWindow("", "ABC"));
            Console.WriteLine(MinWindow("ABC", ""));

            Console.WriteLine(MinWindow("aa", "aa"));
        }

        /*
         * 所求窗口必以 s 中的一个 i (right) 为右边界
         * 对于每一个这样的右边界, 尽可能使左边界靠近它
         * 记录最小的 left 和 right - left + 1
         */
        public string MinWindow(string s, string t)
        {
            int count = 0, distinctChars = 0;
            int[] occurrences = new int[256], targets = new int[256];
            foreach (var ch in t)
            {
                if (targets[ch] == 0)
                {
                    distinctChars++;
                }
                targets[ch]++;
            }

            int left = 0, right = 0;
            int start = 0, length = s.Length;

            while (right < s.Length)
            {
                char ch = s[right];
                occurrences[ch]++;
                if (targets[ch] > 0 && occurrences[ch] == targets[ch])
                {
                    count++;
                }

                while (left <= right && (ch = s[left]) < 256 && (targets[ch] == 0 || occurrences[ch] > targets[ch]))
                {
                    occurrences[ch]--;
                    left++;
                }

                if (count == distinctChars)
                {
                    int len = right - left + 1;
                    if (len < length)
                    {
                        start = left;
                        length = len;
                    }
                }

                right++;
            }

            return count == distinctChars ? s.Substring(start, length) : "";
        }
    }
}
