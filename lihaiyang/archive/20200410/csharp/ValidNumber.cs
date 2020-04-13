// ValidNumber.cs
// Author: hyan23
// 2019.10.28
// https://leetcode.com/problems/valid-number/

/*
Validate if a given string can be interpreted as a decimal number.
Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.
Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
 */

// Runtime: 80 ms, faster than 87.04% of C# online submissions for Valid Number.
// Memory Usage: 24.9 MB, less than 50.00% of C# online submissions for Valid Number.

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
            Console.WriteLine(IsNumber("0"));
            Console.WriteLine(IsNumber(" 0.1"));
            Console.WriteLine(IsNumber("abc"));
            Console.WriteLine(IsNumber("1 a"));
            Console.WriteLine(IsNumber("2e10"));
            Console.WriteLine(IsNumber(" -90e3   "));
            Console.WriteLine(IsNumber(" 1e"));
            Console.WriteLine(IsNumber("e3"));
            Console.WriteLine(IsNumber(" 6e-1"));
            Console.WriteLine(IsNumber(" 99e2.5"));
            Console.WriteLine(IsNumber("53.5e93"));
            Console.WriteLine(IsNumber(" --6"));
            Console.WriteLine(IsNumber("-+3"));
            Console.WriteLine(IsNumber("95a54e53"));

            Console.WriteLine(IsNumber(""));
            Console.WriteLine(IsNumber("  "));
            Console.WriteLine(IsNumber("  e91"));
            Console.WriteLine(IsNumber("0+"));
            Console.WriteLine(IsNumber("5.47e "));
            Console.WriteLine(IsNumber("-"));
            Console.WriteLine(IsNumber("e"));
            Console.WriteLine(IsNumber("2 8"));
            Console.WriteLine(IsNumber("6-8"));

            Console.WriteLine(IsNumber("2e8"));
            Console.WriteLine(IsNumber("-758.32e-34"));
            Console.WriteLine(IsNumber("-95.2e05"));
            Console.WriteLine(IsNumber("-95.2e+05"));

            Console.WriteLine(IsNumber(".1"));
            Console.WriteLine(IsNumber("3."));
            Console.WriteLine(IsNumber("."));
            Console.WriteLine(IsNumber(" .9"));
            Console.WriteLine(IsNumber(".e1"));
            Console.WriteLine(IsNumber("7.e-."));
        }

        public bool IsNumber(string s)
        {
            bool spaceWanted = true;
            bool signWanted = true;
            bool numberWanted = true;
            bool pointWanted = true;
            bool exponentWanted = false;

            int numberCount = 0;
            int pointCount = 0;
            int exponentCount = 0;

            for (int i = 0; i < s.Length; i++)
            {
                switch (s[i])
                {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        numberCount++;

                        spaceWanted = false;
                        signWanted = false;
                        numberWanted = false;
                        pointWanted = pointCount == 0;
                        exponentWanted = exponentCount == 0;
                        break;
                    case ' ':
                        if (!spaceWanted)
                        {
                            for (int j = i + 1; j < s.Length; j++)
                            {
                                if (s[j] != ' ')
                                {
                                    return false;
                                }
                            }
                            return !numberWanted;
                        }

                        spaceWanted = true;
                        signWanted = true;
                        numberWanted = true;
                        pointWanted = true;
                        exponentWanted = false;
                        break;
                    case '.':
                        if (!pointWanted)
                        {
                            return false;
                        }
                        pointCount++;

                        spaceWanted = false;
                        signWanted = false;
                        numberWanted = numberCount == 0;
                        pointWanted = false;
                        exponentWanted = numberCount > 0;
                        break;
                    case '+':
                    case '-':
                        if (!signWanted)
                        {
                            return false;
                        }

                        spaceWanted = false;
                        signWanted = false;
                        numberWanted = true;
                        pointWanted = pointCount == 0;
                        exponentWanted = false;
                        break;
                    case 'E':
                    case 'e':
                        if (!exponentWanted)
                        {
                            return false;
                        }
                        exponentCount++;

                        spaceWanted = false;
                        signWanted = true;
                        numberWanted = true;
                        pointWanted = false;
                        exponentWanted = false;

                        pointCount = 1;
                        break;
                    default:
                        return false;
                }
            }

            return !numberWanted;
        }
    }
}
