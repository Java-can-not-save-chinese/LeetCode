// ContiguousArray.cs
// Author: hyan23
// 2020.04.14
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/

// Runtime: 248 ms, faster than 10.91% of C# online submissions for Contiguous Array.
// Memory Usage: 44.7 MB, less than 100.00% of C# online submissions for Contiguous Array.

using System;
using System.Collections.Generic;

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
            Console.WriteLine(FindMaxLength(new int[] { }));
            Console.WriteLine(FindMaxLength(new int[] { 0 }));
            Console.WriteLine(FindMaxLength(new int[] { 0, 1 }));
            Console.WriteLine(FindMaxLength(new int[] { 0, 1, 0 }));
            Console.WriteLine(FindMaxLength(new int[] { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0 }));
        }

        public int FindMaxLength(int[] nums)
        {
            Dictionary<int, KeyValuePair<int, int>> dict = new Dictionary<int, KeyValuePair<int, int>>();
            int numZeros = 0, numOnes = 0;
            for (int i = 0; i < nums.Length; i++)
            {
                numZeros += nums[i] == 0 ? 1 : 0;
                numOnes += nums[i] == 1 ? 1 : 0;
                int key = numZeros - numOnes;
                if (!dict.ContainsKey(key))
                {
                    dict[key] = new KeyValuePair<int, int>(numZeros == numOnes ? -1 : i, i);
                }
                else
                {
                    dict[key] = new KeyValuePair<int, int>(numZeros == numOnes ? -1 : dict[key].Key, i);
                }
            }
            int maxLength = 0;
            foreach (var val in dict.Values)
            {
                maxLength = Math.Max(maxLength, val.Value - val.Key);
            }
            return maxLength;
        }
    }
}
