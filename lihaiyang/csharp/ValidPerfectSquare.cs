// ValidPerfectSquare.cs
// Author: hyan23
// 2020.05.10
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/

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

        public bool IsPerfectSquare(int num)
        {
            int a = 1;
            int t = num;

            while (a >= t)
            {
                t /= 2;
                a *= 2;
            }

            for (int i = t; i <= a; i++)
            {
                if (i * i == num)
                {
                    return true;
                }
            }

            return false;
        }
    }
}
