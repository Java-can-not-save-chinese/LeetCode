// LengthOfLastWord.cs
// Author: hyan23
// 2019.10.28
// https://leetcode.com/problems/length-of-last-word/

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.
Example:
Input: "Hello World"
Output: 5
 */

// Runtime: 76 ms, faster than 79.87% of C# online submissions for Length of Last Word.
// Memory Usage: 21.6 MB, less than 7.14% of C# online submissions for Length of Last Word.

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
            Console.WriteLine(LengthOfLastWord("hello world"));
            Console.WriteLine(LengthOfLastWord("         "));
            Console.WriteLine(LengthOfLastWord("hello "));
            Console.WriteLine(LengthOfLastWord(" world"));
            Console.WriteLine(LengthOfLastWord("hello"));
            Console.WriteLine(LengthOfLastWord("h"));
            Console.WriteLine(LengthOfLastWord(""));
        }

        public int LengthOfLastWord(string s)
        {
            string trimmed = s.Trim();
            int i = trimmed.Length - 1;
            for (; i >= 0 && trimmed[i] != ' '; i--) ;
            return trimmed.Length - 1 - i;
        }
    }
}
