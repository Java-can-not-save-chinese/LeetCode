// LargestRectangleInHistogram.cs
// Author: hyan23
// 2019.11.24
// https://leetcode.com/problems/largest-rectangle-in-histogram/

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.




Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].




The largest rectangle is shown in the shaded area, which has area = 10 unit.



Example:

Input: [2,1,5,6,2,3]
Output: 10
*/

// Time Limit Exceeded

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
            Console.WriteLine(LargestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
            Console.WriteLine(LargestRectangleArea(new int[] { }));
            Console.WriteLine(LargestRectangleArea(new int[] { 10 }));
            Console.WriteLine(LargestRectangleArea(new int[] { 1, 1, 1, 1, 1 }));
            Console.WriteLine(LargestRectangleArea(new int[] { 1, 1, 0, 1, 1 }));
            Console.WriteLine(LargestRectangleArea(new int[] { 1, 2, 1, 2, 1 }));
            Console.WriteLine(LargestRectangleArea(new int[] { 5, 4, 3, 2, 1 }));
        }

        public int LargestRectangleArea(int[] heights)
        {
            return 0;
        }

        public int LargestRectangleArea2(int[] heights)
        {
            int max = 0;
            Dictionary<int, int> dict = heights.Distinct().ToDictionary(x => x, y => 0);
            foreach (var height in heights)
            {
                foreach (var key in dict.Keys.ToList())
                {
                    if (key > height)
                    {
                        dict[key] = 0;
                    }
                    else
                    {
                        dict[key] += key;
                    }
                    max = Math.Max(max, dict[key]);
                }
            }
            return max;
        }
    }
}
