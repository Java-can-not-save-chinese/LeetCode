// UTF8Validation.cs
// Author: hyan23
// 2020.04.25
// https://leetcode.com/problems/utf-8-validation/

// Runtime: 104 ms, faster than 61.29% of C# online submissions for UTF-8 Validation.
// Memory Usage: 27.2 MB, less than 100.00% of C# online submissions for UTF-8 Validation.

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
            Console.WriteLine(ValidUtf8(new int[] { 197, 130, 1 }));
        }

        public bool ValidUtf8(int[] data)
        {
            int cb = 0;
            for (int i = 0; i < data.Length; i++)
            {
                if (cb > 0)
                {
                    if ((data[i] & 0xc0) != 0x80)
                    {
                        return false;
                    }
                    cb--;
                }
                else
                {
                    switch ((data[i] >> 3) & 0x1f)
                    {
                        case 0x1e:
                            cb = 3;
                            break;
                        case 0x1c:
                        case 0x1d:
                            cb = 2;
                            break;
                        case 0x18:
                        case 0x19:
                        case 0x1a:
                        case 0x1b:
                            cb = 1;
                            break;
                        default:
                            if ((data[i] & 0x80) != 0)
                            {
                                return false;
                            }
                            break;
                    }
                }
            }
            return cb == 0;
        }
    }
}
