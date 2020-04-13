// FirstMissingPositive.cs
// Author: hyan23
// 2019.10.20
// https://leetcode.com/problems/first-missing-positive/

/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
 */

// Runtime: 112 ms, faster than 7.59% of C# online submissions for First Missing Positive.
// Memory Usage: 23.8 MB, less than 9.09% of C# online submissions for First Missing Positive.

// my algorithm consumes non-constant space
// a solution I like: https://leetcode.com/problems/first-missing-positive/discuss/406862/Java-O(n)-time-O(1)-space-beat-100-*-2

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
            Console.WriteLine(FirstMissingPositive(new int[] { 1, 2, 0 }));
            Console.WriteLine(FirstMissingPositive(new int[] { 3, 4, -1, 1 }));
            Console.WriteLine(FirstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
        }

        public int FirstMissingPositive(int[] nums)
        {
            HashSet<int> f = new HashSet<int>();
            f.UnionWith(nums);
            for (int i = 1; ; i++)
            {
                if (!f.Contains(i))
                {
                    return i;
                }
            }
        }
    }
}
