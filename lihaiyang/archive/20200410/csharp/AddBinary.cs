// AddBinary.cs
// Author: hyan23
// 2019.10.30
// https://leetcode.com/problems/add-binary/

/*
Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.
Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 */

// Runtime: 80 ms, faster than 98.29% of C# online submissions for Add Binary.
// Memory Usage: 24 MB, less than 25.00% of C# online submissions for Add Binary.

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
            Console.WriteLine(AddBinary("11", "1"));
            Console.WriteLine(AddBinary("1010", "1011"));
        }

        public string AddBinary(string a, string b)
        {
            char carry = '0';
            char[] c = new char[Math.Max(a.Length, b.Length)];

            int i = a.Length - 1, j = b.Length - 1, k = c.Length - 1;
            for (; i >= 0 && j >= 0; i--, j--, k--)
            {
                switch (carry)
                {
                    case '0':
                        switch (a[i])
                        {
                            case '0':
                                switch (b[j])
                                {
                                    case '0':
                                        c[k] = '0';
                                        break;
                                    case '1':
                                        c[k] = '1';
                                        break;
                                }
                                break;
                            case '1':
                                switch (b[j])
                                {
                                    case '0':
                                        c[k] = '1';
                                        break;
                                    case '1':
                                        c[k] = '0';
                                        carry = '1';
                                        break;
                                }
                                break;
                        }
                        break;

                    case '1':
                        switch (a[i])
                        {
                            case '0':
                                switch (b[j])
                                {
                                    case '0':
                                        c[k] = '1';
                                        carry = '0';
                                        break;
                                    case '1':
                                        c[k] = '0';
                                        break;
                                }
                                break;
                            case '1':
                                switch (b[j])
                                {
                                    case '0':
                                        c[k] = '0';
                                        break;
                                    case '1':
                                        c[k] = '1';
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }

            for (; i >= 0; i--)
            {
                switch (carry)
                {
                    case '0':
                        c[i] = a[i];
                        break;
                    case '1':
                        switch (a[i])
                        {
                            case '0':
                                c[i] = '1';
                                carry = '0';
                                break;
                            case '1':
                                c[i] = '0';
                                break;
                        }
                        break;
                }
            }

            for (; j >= 0; j--)
            {
                switch (carry)
                {
                    case '0':
                        c[j] = b[j];
                        break;
                    case '1':
                        switch (b[j])
                        {
                            case '0':
                                c[j] = '1';
                                carry = '0';
                                break;
                            case '1':
                                c[j] = '0';
                                break;
                        }
                        break;
                }
            }

            string re = new string(c);
            return carry == '1' ? "1" + re : re;
        }
    }
}