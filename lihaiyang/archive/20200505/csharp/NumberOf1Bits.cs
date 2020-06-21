// NumberOf1Bits.cs
// Author: hyan23
// 2020.04.25
// https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/565/

// Runtime: 36 ms
// Memory Usage: 14.7 MB

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
    }
}
