// JewelsAndStones.cs
// Author: hyan23
// 2020.05.03
// https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/

// Runtime: 68 ms
// Memory Usage: 23.5 MB

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

        public int NumJewelsInStones(string J, string S)
        {
            int cnt = 0;
            foreach (var s in S)
            {
                foreach (var j in J)
                {
                    if (s == j)
                    {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
}
