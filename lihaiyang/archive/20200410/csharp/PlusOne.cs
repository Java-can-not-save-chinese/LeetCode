// PlusOne.cs
// Author: hyan23
// 2019.10.30
// https://leetcode.com/problems/plus-one/

/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.
Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */

// Runtime: 236 ms, faster than 95.60% of C# online submissions for Plus One.
// Memory Usage: 29.5 MB, less than 11.54% of C# online submissions for Plus One.

using System;
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
            Console.WriteLine(string.Join(", ", PlusOne(new int[] { 1, 2, 3 })));
            Console.WriteLine(string.Join(", ", PlusOne(new int[] { 4, 3, 2, 1 })));
            Console.WriteLine(string.Join(", ", PlusOne(new int[] { 9 })));
        }

        public int[] PlusOne(int[] digits)
        {
            // Trace.Assert(digits.Length > 0);

            if (digits.All(x => x == 9))
            {
                var re = new int[digits.Length + 1];
                re[0] = 1;
                return re;
            }

            int carry = 1;
            for (int i = digits.Length - 1; i >= 0 && carry > 0; i--)
            {
                digits[i] += carry;
                carry = digits[i] / 10;
                digits[i] %= 10;
            }
            return digits;
        }
    }
}
