// GroupAnagrams.cs
// Author: hyan23
// 2019.10.23
// https://leetcode.com/problems/group-anagrams/

/*
Given an array of strings, group anagrams together.
Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
All inputs will be in lowercase.
The order of your output does not matter.
 */

// Runtime: 308 ms, faster than 79.66% of C# online submissions for Group Anagrams.
// Memory Usage: 37.8 MB, less than 23.53% of C# online submissions for Group Anagrams.

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
            PrintAnagramGroups(new string[] { "eat", "tea", "tan", "ate", "nat", "bat" });
            PrintAnagramGroups(new string[] { });
        }

        private void PrintAnagramGroups(string[] strs)
        {
            foreach (var group in GroupAnagrams(strs))
            {
                Console.WriteLine(string.Join(", ", group));
            }
        }

        public IList<IList<string>> GroupAnagrams(string[] strs)
        {
            Dictionary<string, IList<string>> dict = new Dictionary<string, IList<string>>();

            foreach (var s in strs)
            {
                char[] arr = s.ToArray();
                Array.Sort(arr);
                string key = new string(arr);
                if (!dict.ContainsKey(key))
                {
                    dict[key] = new List<string>();
                }
                dict[key].Add(s);
            }

            return dict.Select(x => x.Value).ToList();
        }
    }
}
