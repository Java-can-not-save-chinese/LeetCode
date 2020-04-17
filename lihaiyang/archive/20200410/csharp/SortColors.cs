// SortColors.cs
// Author: hyan23
// 2019.11.18
// https://leetcode.com/problems/sort-colors/

/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
*/

// Runtime: 232 ms, faster than 97.71% of C# online submissions for Sort Colors.
// Memory Usage: 29.3 MB, less than 16.67% of C# online submissions for Sort Colors.

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
            int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
            SortColors(nums);
            Console.WriteLine(string.Join(", ", nums));

            nums = new int[] { 2, 1, 0, 0, 2, 2, 1, 1, 2, 1 };
            SortColors(nums);
            Console.WriteLine(string.Join(", ", nums));

            nums = new int[] { 1, 1, 2, 2, 0, 1, 0, 1, 0, 1 };
            SortColors(nums);
            Console.WriteLine(string.Join(", ", nums));

            nums = new int[] { 1, 1, 0, 2, 1, 2, 0, 2, 1, 1 };
            SortColors(nums);
            Console.WriteLine(string.Join(", ", nums));

            nums = new int[] { 0 };
            SortColors(nums);
            Console.WriteLine(string.Join(", ", nums));

            nums = new int[] { 1 };
            SortColors(nums);
            Console.WriteLine(string.Join(", ", nums));

            nums = new int[] { 2 };
            SortColors(nums);
            Console.WriteLine(string.Join(", ", nums));

            nums = new int[] { };
            SortColors(nums);
            Console.WriteLine(string.Join(", ", nums));
        }

        public void SortColors(int[] nums)
        {
            int left = 0, right = nums.Length - 1;
            for (int i = 0; i <= right;)
            {
                int num = nums[i];
                nums[i] = 1;
                switch (num)
                {
                    case 0:
                        nums[left++] = 0;
                        i++;
                        break;
                    case 1:
                        i++;
                        break;
                    case 2:
                        nums[i] = nums[right];
                        nums[right--] = 2;
                        break;
                }
            }
        }
    }
}
