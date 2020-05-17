// ReverseBits.cs
// Author: hyan23
// 2020.04.25
// https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/648/

// Runtime: 36 ms
// Memory Usage: 15.1 MB

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
        }

        public uint reverseBits(uint n)
        {
            uint[] lut = new uint[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
            uint result = 0;
            for (int i = 0; i < 8; i++)
            {
                result = result << 4 | lut[n & 0xf];
                n >>= 4;
            }
            return result;
        }
    }
}
