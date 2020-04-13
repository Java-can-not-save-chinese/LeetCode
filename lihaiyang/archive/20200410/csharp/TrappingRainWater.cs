// TrappingRainWater.cs
// Author: hyan23
// 2019.10.20
// https://leetcode.com/problems/trapping-rain-water/

// Runtime: 96 ms, faster than 77.66% of C# online submissions for Trapping Rain Water.
// Memory Usage: 24.3 MB, less than 9.09% of C# online submissions for Trapping Rain Water.

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
            Console.WriteLine(Trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        }

        public int Trap(int[] height)
        {
            if (height.Length <= 2)
            {
                return 0;
            }

            int unit = 0;

            int maxIdx = 0;
            int max = 0;
            for (int i = 0; i < height.Length; i++)
            {
                if (height[i] > max)
                {
                    maxIdx = i;
                    max = height[i];
                }
            }

            int left = 0, right = 0;
            int leftVal = 0, rightVal = 0;
            for (left = 0, right = 1; right < maxIdx; right++)
            {
                leftVal = height[left];
                rightVal = height[right];
                if (leftVal > rightVal)
                {
                    unit += leftVal - rightVal;
                }
                else
                {
                    left = right;
                }
            }

            for (right = height.Length - 1, left = height.Length - 2; left > maxIdx; left--)
            {
                leftVal = height[left];
                rightVal = height[right];
                if (rightVal > leftVal)
                {
                    unit += rightVal - leftVal;
                }
                else
                {
                    right = left;
                }
            }

            return unit;
        }
    }
}
