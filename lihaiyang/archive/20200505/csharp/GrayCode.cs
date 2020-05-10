// GrayCode.cs
// Author: hyan23
// 2020.04.13
// https://leetcode.com/problems/gray-code/

// Runtime: 192 ms
// Memory Usage: 25.8 MB

using System;
using System.Collections.Generic;

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

        /*
         * 000 0
         * 001 0
         * 011 1
         * 010 0
         * 110 2
         * 111 0
         * 101 1
         * 100 0
         */

        /*
         * 0000 0
         * 0001 0
         * 0011 1
         * 0010 0
         * 0110 2
         * 0111 0
         * 0101 1
         * 0100 0
         * 1100 3
         * 1101 0
         * 1111 1
         * 1110 0
         * 1010 2
         * 1011 0
         * 1001 1
         * 1000 0
        */
        public IList<int> GrayCode(int n)
        {
            if (n == 0) { return new List<int>() { 0 }; }
            List<int> l = new List<int>() { 0, 1 };
            for (int i = 2; i <= n; i++)
            {
                int len = l.Count;
                int @base = (int)Math.Pow(2, i - 1);
                for (int j = len - 1; j >= 0; j--)
                {
                    l.Add(@base + l[j]);
                }
            }
            return l;
        }
    }
}
