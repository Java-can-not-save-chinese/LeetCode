// BestTimeToBuyAndSellStockII.cs
// Author: hyan23
// 2020.04.11
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3287/

// Runtime: 96 ms
// Memory Usage: 25.3 MB

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
            int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
            Console.WriteLine(MaxProfit(prices));
            prices = new int[] { 1, 2, 3, 4, 5 };
            Console.WriteLine(MaxProfit(prices));
            prices = new int[] { 7, 6, 4, 3, 1 };
            Console.WriteLine(MaxProfit(prices));
        }

        public int MaxProfit(int[] prices)
        {
            int max = 0;
            int buy = prices[0];
            foreach (var p in prices)
            {
                if (buy < p)
                {
                    max += p - buy;
                }
                buy = p;
            }
            return max;
        }
    }
}
