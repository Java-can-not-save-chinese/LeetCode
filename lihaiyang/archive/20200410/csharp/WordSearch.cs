// WordSearch.cs
// Author: hyan23
// 2019.11.20
// https://leetcode.com/problems/word-search/

/* 
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

// Runtime: 152 ms, faster than 28.40% of C# online submissions for Word Search.
// Memory Usage: 46.1 MB, less than 100.00% of C# online submissions for Word Search.

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
            Console.WriteLine(Exist(
                new char[][]
                {
                    new char[] { 'A','B','C','E' },
                    new char[] { 'S','F','C','S' },
                    new char[] { 'A','D','E','E' },
                }, "ABCCED"));

            Console.WriteLine(Exist(
                new char[][]
                {
                    new char[] { 'A','B','C','E' },
                    new char[] { 'S','F','C','S' },
                    new char[] { 'A','D','E','E' },
                }, "SEE"));

            Console.WriteLine(Exist(
                new char[][]
                {
                    new char[] { 'A','B','C','E' },
                    new char[] { 'S','F','C','S' },
                    new char[] { 'A','D','E','E' },
                }, "ABCB"));

            Console.WriteLine(Exist(
                new char[][] { }, "ABCD"));

            Console.WriteLine(Exist(
                new char[][]
                {
                    new char[] { 'A','B','C','E' },
                    new char[] { 'S','F','C','S' },
                    new char[] { 'A','D','E','E' },
                }, ""));

            Console.WriteLine(Exist(
                new char[][]
                {
                    new char[] { 'A','B','C','E' },
                    new char[] { 'S','F','E','S' },
                    new char[] { 'A','D','E','E' },
                }, "ABCESEEEFS"));
        }

        public bool Exist(char[][] board, string word)
        {
            for (int i = 0; i < board.Length; i++)
            {
                for (int j = 0; j < board[i].Length; j++)
                {
                    bool[,] visited = new bool[board.Length, board[0].Length];
                    if (Backtracking(board, visited, i, j, word, 0))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        private bool Backtracking(char[][] board, bool[,] visited, int i, int j, string word, int pos)
        {
            if (pos == word.Length)
            {
                return true;
            }

            if (i < 0 || i >= board.Length ||
                j < 0 || j >= board[i].Length ||
                visited[i, j])
            {
                return false;
            }

            if (board[i][j] == word[pos])
            {
                visited[i, j] = true;
                bool res = Backtracking(board, visited, i - 1, j, word, pos + 1) ||
                    Backtracking(board, visited, i + 1, j, word, pos + 1) ||
                    Backtracking(board, visited, i, j - 1, word, pos + 1) ||
                    Backtracking(board, visited, i, j + 1, word, pos + 1);
                visited[i, j] = false;
                return res;
            }
            else
            {
                return false;
            }
        }
    }
}
