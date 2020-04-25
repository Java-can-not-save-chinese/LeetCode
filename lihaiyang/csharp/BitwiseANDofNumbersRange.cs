// BitwiseANDofNumbersRange.cs
// Author: hyan23
// 2020.04.24
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3308/

// Runtime: 56 ms
// Memory Usage: 15.5 MB

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
            Console.WriteLine(RangeBitwiseAnd(724524, 776435));
        }

        public int RangeBitwiseAnd(int m, int n)
        {
            int a = 0;
            for (int i = 31; i >= 0; i--)
            {
                if (((m >> i) & 1) == ((n >> i) & 1))
                {
                    a++;
                }
                else
                {
                    break;
                }
            }
            return n & (~0 << (32 - a));
        }
    }
}
