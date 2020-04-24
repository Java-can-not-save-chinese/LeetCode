// ProductOfArrayExceptSelf.cs
// Author: hyan23
// 2020.04.16
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/

// Runtime: 260 ms
// Memory Usage: 36.1 MB

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

        public int[] ProductExceptSelf(int[] nums)
        {
            int[] l1 = new int[nums.Length + 1];
            l1[0] = 1;
            int[] l2 = new int[nums.Length + 2];
            l2[nums.Length + 1] = 1;

            for (int i = 1; i <= nums.Length; i++)
            {
                l1[i] = l1[i - 1] * nums[i - 1];
                l2[nums.Length + 1 - i] = l2[nums.Length + 1 - i + 1] * nums[nums.Length - i];
            }

            int[] output = new int[nums.Length];
            for (int i = 1; i <= nums.Length; i++)
            {
                output[i - 1] = l1[i - 1] * l2[i + 1];
            }

            return output;
        }
    }
}
