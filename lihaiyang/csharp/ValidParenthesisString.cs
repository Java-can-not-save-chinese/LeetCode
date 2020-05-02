// ValidParenthesisString.cs
// Author: hyan23
// 2020.04.17
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/

// Runtime: 72 ms
// Memory Usage: 21.8 MB

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
            Console.WriteLine(CheckValidString("()"));
            Console.WriteLine(CheckValidString("(*)"));
            Console.WriteLine(CheckValidString("(*))"));
            Console.WriteLine(CheckValidString("*((*)))"));
            Console.WriteLine(CheckValidString("*((*)***))"));
            Console.WriteLine(CheckValidString("(*((*)*()**))*"));

            Console.WriteLine(CheckValidString("("));
            Console.WriteLine(CheckValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
            Console.WriteLine(CheckValidString("(*()"));
            Console.WriteLine(CheckValidString("(())(())(((() * ()()()))()((()()(*()())))(((*)()"));
        }

        public bool CheckValidString(string s)
        {
            int left = 0, star = 0, right = 0;
            foreach (var ch in s)
            {
                switch (ch)
                {
                    case '(':
                        left++;
                        break;
                    case ')':
                        if (left > 0)
                        {
                            left--;
                            right = Math.Min(right, left);
                        }
                        else if (star > 0)
                        {
                            star--;
                        }
                        else
                        {
                            return false;
                        }
                        break;
                    case '*':
                        if (left > 0)
                        {
                            right++;
                        }
                        star++;
                        break;
                }
            }
            //Console.WriteLine($"{left}, {right}");
            return right >= left;
        }
    }
}
