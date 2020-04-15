// PerformStringShifts.cs
// Author: hyan23
// 2020.04.15
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/

// Runtime: 100 ms
// Memory Usage: 24.5 MB

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
            /*
            "abcfeafaefdsfdsafdafdafdsasdaff"
            [[0,1],[1,2],[1,6],[0,11],[1,5],[0,32],[1,10],[1,6],[0,13],[1,21],[1,9],[0,11],[1,4]]
            */
        }

        public string StringShift(string s, int[][] shift)
        {
            int move = shift.Select(x => x[0] == 0 ? -x[1] : x[1]).Sum() % s.Length;
            return move >= 0 ?
                s.Substring(s.Length - move) + s.Substring(0, s.Length - move) :
                s.Substring(-move) + s.Substring(0, -move);
        }
    }
}
