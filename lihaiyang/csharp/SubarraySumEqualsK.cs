// SubarraySumEqualsK.cs
// Author: hyan23
// 2020.04.24
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/

// Runtime: 116 ms
// Memory Usage: 37 MB

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
            Console.WriteLine(SubarraySum(new int[] { 1, 1, 1, 4, 2, -1, -4, 3, 1, -2, 4, -10, 4, 5, -7, 10, -9, 1 }, 2));
        }

        public int SubarraySum(int[] nums, int k)
        {
            Dictionary<int, List<int>> dict = new Dictionary<int, List<int>>();
            int sum = 0;
            for (int i = 0; i < nums.Length; i++)
            {
                sum += nums[i];
                nums[i] = sum;

                if (!dict.ContainsKey(sum))
                {
                    dict[sum] = new List<int>();
                }
                dict[sum].Add(i);
            }

            int numSubarray = dict.ContainsKey(k) ? dict[k].Count : 0;
            for (int i = nums.Length - 1; i >= 0; i--)
            {
                int target = nums[i] - k;
                numSubarray += dict.ContainsKey(target) ? dict[target].Where(x => x < i).Count() : 0;
            }
            return numSubarray;
        }
    }
}
