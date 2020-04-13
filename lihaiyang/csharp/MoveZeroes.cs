// MoveZeroes.cs
// Author: hyan23
// 2020.04.11
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3286/

// Runtime: 236 ms
// Memory Usage: 31.7 MB

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
            int[] nums = new int[] { 0, 1, 0, 3, 12 };
            MoveZeroes(nums);
            Console.WriteLine(string.Join(", ", nums));
        }

        public void MoveZeroes(int[] nums)
        {
            int tail = 0;
            for (int i = 0; i < nums.Length; i ++)
            {
                if (nums[i] != 0)
                {
                    nums[tail] = nums[i];
                    if (tail != i)
                    {
                        nums[i] = 0;
                    }
                    tail++;
                }
            }
        }
    }
}
