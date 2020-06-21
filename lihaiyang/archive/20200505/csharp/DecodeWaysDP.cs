// DecodeWaysDP.cs
// Author: hyan23
// 2020.04.13
// https://leetcode.com/problems/decode-ways/

// Runtime: 72 ms, faster than 86.79% of C# online submissions for Decode Ways.
// Memory Usage: 22.4 MB, less than 12.50% of C# online submissions for Decode Ways.

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

        public class Solution
        {
            public int NumDecodings(string s)
            {
                if (s.Length > 0)
                {
                    int[] dp = new int[s.Length + 1];
                    dp[0] = dp[1] = s[0] >= '1' && s[0] <= '9' ? 1 : 0;
                    for (int i = 2; i <= s.Length; i++)
                    {
                        int tail = i - 1;
                        if (s[tail - 1] == '1' || (s[tail - 1] == '2' && s[tail] <= '6'))
                        {
                            dp[i] = s[tail] != '0' ? dp[i - 1] + dp[i - 2] : dp[i - 2];
                        }
                        else
                        {
                            dp[i] = s[tail] != '0' ? dp[i - 1] : 0;
                        }
                    }
                    return dp[s.Length];
                }
                else
                {
                    return 0;
                }
            }
        }
    }
}
