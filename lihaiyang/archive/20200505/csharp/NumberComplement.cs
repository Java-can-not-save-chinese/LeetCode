// NumberComplement.cs
// Author: hyan23
// 2020.05.05
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/

// Runtime: 40 ms
// Memory Usage: 14.6 MB

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

        public int FindComplement(int num)
        {
            int mask = num;
            mask |= mask >> 1;
            mask |= mask >> 2;
            mask |= mask >> 4;
            mask |= mask >> 8;
            mask |= mask >> 16;
            return num == 0 ? 1 : (~num & mask);
        }
    }
}
