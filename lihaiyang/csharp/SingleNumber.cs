// SingleNumber.cs
// Author: hyan23
// 2020.04.10
// https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/528/week-1/3283/

// Runtime: 100 ms
// Memory Usage: 26.4 MB

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

        public int SingleNumber(int[] nums)
        {
            return nums.Aggregate(0, (a, b) => a ^ b);
        }
    }
}
