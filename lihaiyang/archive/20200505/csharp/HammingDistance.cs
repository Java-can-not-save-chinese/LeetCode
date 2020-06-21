// HammingDistance.cs
// Author: hyan23
// 2020.04.25
// https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/762/

// Runtime: 40 ms
// Memory Usage: 14.6 MB

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
            Console.WriteLine(HammingDistance(12452, 4342235));
        }

        public int HammingWeight(uint n)
        {
            int nb = 0;
            int[] lut = new int[] { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
            for (int i = 0; i < 8; i++)
            {
                nb += lut[n & 0xf];
                n >>= 4;
            }
            return nb;
        }

        public int HammingDistance(int x, int y)
        {
            return HammingWeight((uint)(x ^ y));
        }
    }
}
