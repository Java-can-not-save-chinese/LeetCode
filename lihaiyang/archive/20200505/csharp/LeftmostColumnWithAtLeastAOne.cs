// LeftmostColumnWithAtLeastAOne.cs
// Author: hyan23
// 2020.04.24
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/

// Runtime: 108 ms
// Memory Usage: 26.4 MB

using System.Collections.Generic;

namespace csharp
{
    public class BinaryMatrix
    {
        public int Get(int row, int col) => 0;
        public IList<int> Dimensions() => null;
    }

    public class Program
    {
        public static void Main()
        {
            new Program().Test();
        }

        public void Test()
        {
        }

        public int LeftMostColumnWithOne(BinaryMatrix binaryMatrix)
        {
            var dims = binaryMatrix.Dimensions();
            int rows = dims[0], cols = dims[1];

            int left = 0, right = cols - 1;
            int colWithOne = -1;

            while (left <= right)
            {
                int mid = (left + right) / 2;

                int col = -1;
                for (int i = 0; i < rows; i++)
                {
                    if (binaryMatrix.Get(i, mid) == 1)
                    {
                        colWithOne = col = mid;
                        break;
                    }
                }

                if (col != -1)
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }

            return colWithOne;
        }
    }
}