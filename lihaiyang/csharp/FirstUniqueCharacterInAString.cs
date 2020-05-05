// FirstUniqueCharacterInAString.cs
// Author: hyan23
// 2020.05.05
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/

// Runtime: 76 ms
// Memory Usage: 32 MB

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

        public int FirstUniqChar(string s)
        {
            int[] mp = new int[256];
            for (int i = 0; i < s.Length; i++)
            {
                char ch = s[i];
                if (mp[ch] == 0)
                {
                    mp[ch] = i + 1;
                }
                else
                {
                    mp[ch] = -1;
                }
            }

            int min = s.Length;
            for (char ch = 'a'; ch <= 'z'; ch++)
            {
                if (mp[ch] > 0)
                {
                    min = Math.Min(min, mp[ch] - 1);
                }
            }

            return min == s.Length ? -1 : min;
        }
    }
}
