// MajorityElement.cs
// Author: hyan23
// 2020.05.07
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/

// Runtime: 124 ms
// Memory Usage: 29.6 MB

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

        public int MajorityElement(int[] nums)
        {
            Array.Sort(nums);
            return nums[nums.Length / 2];
        }
    }
}
