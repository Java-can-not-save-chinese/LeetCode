// PermutationSequence.cs
// Author: hyan23
// 2019.10.28
// https://leetcode.com/problems/permutation-sequence/

/*
The set [1,2,3,...,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
Note:
Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:
Input: n = 3, k = 3
Output: "213"
Example 2:
Input: n = 4, k = 9
Output: "2314"
 */

// Runtime: 84 ms, faster than 75.27% of C# online submissions for Permutation Sequence.
// Memory Usage: 22 MB, less than 100.00% of C# online submissions for Permutation Sequence.

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
            Console.WriteLine(GetPermutation(3, 3));
            Console.WriteLine(GetPermutation(4, 9));
            Console.WriteLine(GetPermutation(1, 1));
            Console.WriteLine(GetPermutation(2, 2));
            Console.WriteLine(GetPermutation(3, 4));
            Console.WriteLine(GetPermutation(4, 4));
        }

        public string GetPermutation(int n, int k)
        {
            int[] factorial = new int[n];
            factorial[0] = 1;
            for (int i = 1; i < n; i++)
            {
                factorial[i] = factorial[i - 1] * i;
            }

            int[] perm = new int[n + 1];
            List<int> candidates = Enumerable.Range(1, n).ToList();
            for (int i = 1; i <= n; i++)
            {
                if (k > factorial[n - i])
                {
                    perm[i] = (k - 1) / factorial[n - i];
                    k -= perm[i] * factorial[n - i];
                }
                perm[i] = candidates[perm[i] % candidates.Count];
                candidates.Remove(perm[i]);
            }
            return string.Join("", perm.Skip(1));
        }
    }
}
