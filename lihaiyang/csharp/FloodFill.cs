// FloodFill.cs
// Author: hyan23
// 2020.05.13
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/

// Runtime: 256 ms
// Memory Usage: 33 MB

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

        public int[][] FloodFill(int[][] image, int sr, int sc, int newColor)
        {
            Helper(image, sr, sc, image[sr][sc], newColor);
            return image;
        }

        private void Helper(int[][] image, int sr, int sc, int oldColor, int newColor)
        {
            if (oldColor == newColor)
            {
                return;
            }
            int m = image.Length, n = image[0].Length;
            if (sr < 0 || sr >= m || sc < 0 || sc >= n)
            {
                return;
            }
            if (image[sr][sc] != oldColor)
            {
                return;
            }
            image[sr][sc] = newColor;
            Helper(image, sr - 1, sc, oldColor, newColor);
            Helper(image, sr + 1, sc, oldColor, newColor);
            Helper(image, sr, sc - 1, oldColor, newColor);
            Helper(image, sr, sc + 1, oldColor, newColor);
        }
    }
}
