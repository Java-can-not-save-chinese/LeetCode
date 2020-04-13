// JumpGameII.cs
// Author: hyan23
// 2019.10.21
// https://leetcode.com/problems/jump-game-ii/

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
Example:
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:
You can assume that you can always reach the last index.
 */

// Runtime: 112 ms, faster than 29.38% of C# online submissions for Jump Game II.
// Memory Usage: 25.7 MB, less than 9.09% of C# online submissions for Jump Game II.

/*
 * 贪心选择: 设当前下标为 i，每一次前进的步数为 jump。遍历 步数1 ~ 最大步数，选择能使 i+jump+nums[i+jump] 最大的步数
 * */

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
            Console.WriteLine(Jump(new int[] { 2, 3, 1, 1, 4 }));
            Console.WriteLine(Jump(new int[] { }));
            Console.WriteLine(Jump(new int[] { 2 }));
            Console.WriteLine(Jump(new int[] { 3, 2, 1 }));
        }

        public int Jump(int[] nums)
        {
            int steps = 0;
            int index = 0;

            while (index < nums.Length - 1)
            {
                int maxJump = nums[index];
                int mostFar = 0;
                int chosenJump = 0;
                for (int i = 1; i <= maxJump && index + i < nums.Length; i++)
                {
                    int t = Math.Min(nums.Length - 1, index + i + nums[index + i]);
                    if (t >= mostFar && i > chosenJump/* definitely*/)
                    {
                        mostFar = t;
                        chosenJump = i;
                    }
                }

                index += chosenJump;
                steps++;
            }

            return steps;
        }
    }
}
