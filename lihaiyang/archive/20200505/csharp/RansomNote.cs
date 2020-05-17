// RansomNote.cs
// Author: hyan23
// 2020.05.03
// https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/

// Runtime: 88 ms
// Memory Usage: 30.6 MB

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

        public bool CanConstruct(string ransomNote, string magazine)
        {
            Dictionary<char, int> dict = magazine.GroupBy(x => x).ToDictionary(x => x.Key, y => y.Count());
            foreach (var ch in ransomNote)
            {
                if (dict.ContainsKey(ch) && dict[ch] > 0)
                {
                    dict[ch]--;
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
    }
}
