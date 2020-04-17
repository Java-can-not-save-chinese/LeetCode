// InsertInterval.cs
// Author: hyan23
// 2019.10.27
// https://leetcode.com/problems/insert-interval/

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

// Runtime: 252 ms, faster than 99.07% of C# online submissions for Insert Interval.
// Memory Usage: 32.7 MB, less than 100.00% of C# online submissions for Insert Interval.

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

        public int[][] Insert(int[][] intervals, int[] newInterval)
        {
            List<int[]> intervalList = new List<int[]>();

            foreach (var @int in intervals)
            {
                if (@int[1] < newInterval[0] || @int[0] > newInterval[1])
                {
                    intervalList.Add(@int);
                }
                else
                {
                    newInterval[0] = Math.Min(@int[0], newInterval[0]);
                    newInterval[1] = Math.Max(@int[1], newInterval[1]);
                }
            }
            intervalList.Add(newInterval);
            intervalList.Sort((x, y) => x[0] - y[0]);

            return intervalList.ToArray();
        }
    }
}
