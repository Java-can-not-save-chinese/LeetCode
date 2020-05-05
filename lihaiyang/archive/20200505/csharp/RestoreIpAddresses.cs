// RestoreIpAddresses.cs
// Author: hyan23
// 2020.04.15
// https://leetcode.com/problems/restore-ip-addresses/

// Runtime: 232 ms, faster than 96.10% of C# online submissions for Restore IP Addresses.
// Memory Usage: 31.6 MB, less than 100.00% of C# online submissions for Restore IP Addresses.

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
            RestoreIpAddresses("25525511135");
        }

        public IList<string> RestoreIpAddresses(string s)
        {
            IList<string> addrs = new List<string>();
            int[] addr = new int[4];
            Helper(s, 0, addr, 0, addrs);
            return addrs;
        }

        private void Helper(string s, int spos, int[] addr, int apos, IList<string> addrs)
        {
            if (spos < s.Length && apos < addr.Length)
            {
                for (int i = 1; i <= Math.Min(3, s.Length - spos); i++)
                {
                    int number = int.Parse(s.Substring(spos, i));
                    if (number <= 255)
                    {
                        addr[apos] = number;
                        Helper(s, spos + i, addr, apos + 1, addrs);
                    }
                    if (number == 0)
                    {
                        break;
                    }
                }
            }
            else
            {
                if (spos == s.Length && apos == 4)
                {
                    addrs.Add(string.Join(".", addr));
                }
            }
        }
    }
}
