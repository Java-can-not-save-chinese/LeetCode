// MergeSortedArray.cs
// Author: hyan23
// 2020.04.13
// https://leetcode.com/problems/merge-sorted-array/

// Runtime: 240 ms, faster than 61.25% of C# online submissions for Merge Sorted Array.
// Memory Usage: 30.3 MB, less than 10.00% of C# online submissions for Merge Sorted Array.

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

        public void Merge(int[] nums1, int m, int[] nums2, int n)
        {
            int j = m - 1, k = n - 1;
            for (int i = m + n - 1; i >= 0; i--)
            {
                if (j >= 0 && (k < 0 || nums1[j] >= nums2[k]))
                {
                    nums1[i] = nums1[j--];
                }
                else
                {
                    nums1[i] = nums2[k--];
                }
            }
        }
    }
}
