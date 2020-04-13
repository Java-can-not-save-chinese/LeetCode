// DecodeWays.cs
// Author: hyan23
// 2020.04.13
// https://leetcode.com/problems/decode-ways/

// Runtime: 908 ms, faster than 6.61% of C# online submissions for Decode Ways.
// Memory Usage: 22.7 MB, less than 12.50% of C# online submissions for Decode Ways.

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

        public int NumDecodings(string s)
        {
            if (s.Length > 0)
            {
                int ways = 0;
                Helper(s, 0, ref ways);
                return ways;
            }
            else
            {
                return 0;
            }
        }

        private void Helper(string s, int si, ref int ways)
        {
            if (si < s.Length)
            {
                switch (s[si])
                {
                    case '1':
                        Helper(s, si + 1, ref ways);
                        if (si < s.Length - 1)
                        {
                            Helper(s, si + 2, ref ways);
                        }
                        break;
                    case '2':
                        Helper(s, si + 1, ref ways);
                        if (si < s.Length - 1 && s[si + 1] - '0' <= 6)
                        {
                            Helper(s, si + 2, ref ways);
                        }
                        break;
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        Helper(s, si + 1, ref ways);
                        break;
                    default:
                        return;
                }
            }
            else
            {
                ways++;
            }
        }
    }
}
