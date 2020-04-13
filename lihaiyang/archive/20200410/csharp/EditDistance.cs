// EditDistance.cs
// Author: hyan23
// 2019.11.03
// https://leetcode.com/problems/edit-distance/

/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */

// Runtime: 68 ms, faster than 100.00% of C# online submissions for Edit Distance.
// Memory Usage: 26 MB, less than 14.29% of C# online submissions for Edit Distance.

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
            Console.WriteLine(MinDistance("horse", "ros"));
            Console.WriteLine(MinDistance("intention", "execution"));
            Console.WriteLine(MinDistance("eat", "sea"));
            Console.WriteLine(MinDistance("ab", "bc"));
            Console.WriteLine(MinDistance("zoologicoarchaeologist", "zoogeologist"));

            Console.WriteLine(MinDistance("a", "b"));
            Console.WriteLine(MinDistance("a", ""));
        }

        public int MinDistance(string word1, string word2)
        {
            int[,] dp = new int[word1.Length + 1, word2.Length + 1];

            dp[0, 0] = 0;
            for (int i = 1; i <= word2.Length; i++)
            {
                dp[0, i] = dp[0, i - 1] + 1;
            }
            for (int i = 1; i <= word1.Length; i++)
            {
                dp[i, 0] = dp[i - 1, 0] + 1;
            }

            for (int i = 1; i <= word1.Length; i++)
            {
                for (int j = 1; j <= word2.Length; j++)
                {
                    // why?
                    if (word1[i - 1] == word2[j - 1])
                    {
                        dp[i, j] = dp[i - 1, j - 1];
                    }
                    else
                    {
                        dp[i, j] = Math.Min(dp[i - 1, j - 1], Math.Min(dp[i - 1, j], dp[i, j - 1])) + 1;
                    }
                }
            }

            return dp[word1.Length, word2.Length];
        }
    }
}
