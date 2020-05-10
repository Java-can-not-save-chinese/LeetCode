// LastStoneWeight.cs
// Author: hyan23
// 2020.04.12
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/

// Runtime: 100 ms
// Memory Usage: 24.8 MB

using System;
using System.Collections.Generic;
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
            Console.WriteLine(LastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
        }

        public int LastStoneWeight(int[] stones)
        {
            SortedDictionary<int, int> sl = new SortedDictionary<int, int>(
                stones.GroupBy(x => x, (x, y) => new KeyValuePair<int, int>(x, y.Count()))
                .ToDictionary(x => x.Key, x => x.Value));

            while (sl.Count >= 2)
            {
                if (sl.Last().Value % 2 == 0)
                {
                    sl.Remove(sl.Last().Key);
                }
                else
                {
                    int y = sl.Last().Key;
                    sl.Remove(y);
                    int x = sl.Last().Key;
                    _ = sl[x] > 1 ? --sl[x] > 0 : sl.Remove(x);
                    int z = y - x;
                    if (sl.ContainsKey(z))
                    {
                        sl[z]++;
                    }
                    else
                    {
                        sl[z] = 1;
                    }
                }
            }

            if (sl.Count > 0)
            {
                var first = sl.First();
                return first.Value % 2 == 0 ? 0 : first.Key;
            }
            else
            {
                return 0;
            }
        }
    }
}
