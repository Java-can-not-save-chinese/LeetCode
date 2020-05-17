// CheckIfItIsAStraightLine.cs
// Author: hyan23
// 2020.05.09
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/

// Runtime: 100 ms
// Memory Usage: 25.9 MB

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

        public bool CheckStraightLine(int[][] coordinates)
        {
            if (coordinates.Length == 2)
            {
                return true;
            }

            int dy = coordinates[0][1] - coordinates[1][1];
            int dx = coordinates[0][0] - coordinates[1][0];

            for (int i = 3; i < coordinates.Length; i++)
            {
                if (dx * (coordinates[i][1] - coordinates[0][1]) != dy * (coordinates[i][0] - coordinates[0][0]))
                {
                    return false;
                }
            }
            return true;
        }
    }
}
