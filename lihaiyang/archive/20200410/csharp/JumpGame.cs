// JumpGame.cs
// Author: hyan23
// 2019.10.27
// https://leetcode.com/problems/jump-game/

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */

// Runtime: 104 ms （67.19 faster)
// Memory Usage: 25.5 MB

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
            Console.WriteLine(CanJump(new int[] { 2, 3, 1, 1, 4 }));
            Console.WriteLine(CanJump(new int[] { 3, 2, 1, 0, 4 }));
            Console.WriteLine(CanJump(new int[] { }));
            Console.WriteLine(CanJump(new int[] { 0 }));
            Console.WriteLine(CanJump(new int[] { 2, 3, 1, 1, 4, 0 }));
        }

        public bool CanJump(int[] nums)
        {
            int maxLength = 0;
            for (int i = 0; i < nums.Length - 1; i++)
            {
                if (nums[i] == 0 && maxLength == 0)
                {
                    return false;
                }
                if (nums[i] >= maxLength)
                {
                    maxLength = nums[i];
                }
                maxLength--;
            }
            return true;
        }
    }
}
