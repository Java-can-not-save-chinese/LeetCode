// ValidSudoku.go
// Author: hyan23
// 2019.08.19
// https://leetcode.com/problems/valid-sudoku/

/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true

Example 2:
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

	Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
*/

/*
Runtime: 0 ms, faster than 100.00% of Go online submissions for Valid Sudoku.
Memory Usage: 2.7 MB, less than 100.00% of Go online submissions for Valid Sudoku.
*/

package main

func isValidSudoku(board [][]byte) bool {
	check := [9][9][3]int{}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			ch := board[i][j]
			if ch != '.' {
				digit := int(ch - '0')
				check[i][digit-1][0]++
				check[digit-1][j][1]++
				check[i-i%3+(digit-1)/3][j-j%3+(digit-1)%3][2]++
			}
		}
	}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			if check[i][j][0] > 1 || check[i][j][1] > 1 || check[i][j][2] > 1 {
				return false
			}
		}
	}
	return true
}

func main() {

}
