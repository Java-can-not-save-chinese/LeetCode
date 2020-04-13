// MergeIntervals.cs
// Author: hyan23
// 2019.10.27
// https://leetcode.com/problems/merge-intervals/

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

// Runtime: 256 ms, faster than 99.71% of C# online submissions for Merge Intervals.
// Memory Usage: 32.6 MB, less than 10.00% of C# online submissions for Merge Intervals.

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
        }

        public int[][] Merge(int[][] intervals)
        {
            List<int[]> intervalList = new List<int[]>();
            if (intervals.Length == 0)
            {
                return intervalList.ToArray();
            }

            Array.Sort(intervals, (x, y) => x[0] - y[0]);
            int[] leftMost = intervals[0];
            for (int i = 1; i < intervals.Length; i++)
            {
                int[] @new = intervals[i];
                if (leftMost[1] >= @new[0])
                {
                    leftMost[1] = Math.Max(leftMost[1], @new[1]);
                }
                else
                {
                    intervalList.Add(leftMost);
                    leftMost = intervals[i];
                }
            }
            intervalList.Add(leftMost);

            return intervalList.ToArray();
        }
    }
}
