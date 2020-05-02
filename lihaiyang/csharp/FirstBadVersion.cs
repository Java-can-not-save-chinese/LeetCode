// FirstBadVersion.cs
// Author: hyan23
// 2020.04.25
// https://leetcode.com/explore/featured/card/top-interview-questions-easy/96/sorting-and-searching/774/

// Runtime: 40 ms
// Memory Usage: 14.5 MB

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
            // 2126753390
            // 1702766719
        }

        private bool IsBadVersion(int version)
        {
            return true;
        }

        public int FirstBadVersion(int n)
        {
            int badVersion = n;

            int left = 1, right = n;
            while (left <= right)
            {
                int mid = left + (right - left) / 2;

                if (IsBadVersion(mid))
                {
                    badVersion = mid;
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }

            return badVersion;
        }
    }
}
