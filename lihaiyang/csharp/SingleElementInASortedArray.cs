// SingleElementInASortedArray.cs
// Author: hyan23
// 2020.05.13
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/

// Runtime: 92 ms
// Memory Usage: 25.7 MB

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
            Console.WriteLine(SingleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
            Console.WriteLine(SingleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
        }

        public int SingleNonDuplicate(int[] nums)
        {
            // nums.Length != 0
            if (nums.Length <= 1)
            {
                return nums[0];
            }

            int left = 0, right = nums.Length - 1;
            while (left < right)
            {
                // Console.WriteLine($"{left}, {right}");
                int mid = left + (right - left) / 2;
                if ((mid & 1) == 0)
                {
                    if (nums[mid] == nums[mid + 1])
                    {
                        left = mid + 2;
                    }
                    else
                    {
                        right = mid;
                    }
                }
                else
                {
                    if (nums[mid] != nums[mid + 1])
                    {
                        left = mid + 1;
                    }
                    else
                    {
                        right = mid - 1;
                    }
                }
            }

            return nums[left];
        }
    }
}
