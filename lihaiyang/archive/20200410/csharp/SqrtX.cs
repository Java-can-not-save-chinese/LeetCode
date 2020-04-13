// SqrtX.cs
// Author: hyan23
// 2019.10.31
// https://leetcode.com/problems/sqrtx/

/*
Implement int sqrt(int x).
Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
Example 1:
Input: 4
Output: 2
Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */

// Runtime: 32 ms, faster than 99.44% of C# online submissions for Sqrt(x).
// Memory Usage: 14.2 MB, less than 7.14% of C# online submissions for Sqrt(x).

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
            Console.WriteLine(MySqrt(0));
            Console.WriteLine(MySqrt(1));
            Console.WriteLine(MySqrt(2));
            Console.WriteLine(MySqrt(3));
            Console.WriteLine(MySqrt(4));
            Console.WriteLine(MySqrt(8));
            Console.WriteLine(MySqrt(2147483647));
            Console.WriteLine(MySqrt(2147395599));
        }

        public int MySqrt(int x)
        {
            if (x < 2)
            {
                return x;
            }
            int low = 1, high = x / 2;
            while (low < high)
            {
                float mid = (low + high) / 2;
                float p = mid * mid;
                if (p > x)
                {
                    high = (int)(mid - 1);
                }
                else
                {
                    low = (int)(mid + 1);
                }
            }
            return (double)low * low > x ? low - 1 : low;
        }
    }
}
