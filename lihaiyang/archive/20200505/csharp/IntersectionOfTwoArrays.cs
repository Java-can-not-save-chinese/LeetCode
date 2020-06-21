// IntersectionOfTwoArrays.cs
// Author: hyan23
// 2020.05.05
// https://leetcode.com/problems/intersection-of-two-arrays/

// Runtime: 232 ms, faster than 97.26% of C# online submissions for Intersection of Two Arrays.
// Memory Usage: 31.6 MB, less than 100.00% of C# online submissions for Intersection of Two Arrays.

// Other solutions are:
// 1. Brute force
// 2. Sort two arrays, use two pointers to consume them
// 3. Sort one of the array, use binary search on it

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
        }

        public int[] Intersection(int[] nums1, int[] nums2)
        {
            HashSet<int> hs = nums2.Distinct().ToHashSet();
            HashSet<int> result = new HashSet<int>();
            foreach (var e in nums1)
            {
                if (hs.Contains(e) && !result.Contains(e))
                {
                    result.Add(e);
                }
            }
            return result.ToArray();
        }
    }
}
