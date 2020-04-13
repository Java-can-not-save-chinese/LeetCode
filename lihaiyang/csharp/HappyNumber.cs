// HappyNumber.cs
// Author: hyan23
// 2020.04.11
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/

// Runtime: 44 ms
// Memory Usage: 16.8 MB

using System.Collections.Generic;

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

        public bool IsHappy(int n)
        {
            HashSet<int> note = new HashSet<int>() { n };
            while (true)
            {
                int sum = 0;
                while (n > 0)
                {
                    int digit = n % 10;
                    sum += digit * digit;
                    n /= 10;
                }
                if (sum == 1)
                {
                    return true;
                }
                else if (note.Contains(sum))
                {
                    return false;
                }
                note.Add(sum);
                n = sum;
            }
        }
    }
}
