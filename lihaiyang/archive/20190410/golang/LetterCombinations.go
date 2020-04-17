// LetterCombinations.go
// Author: hyan23
// 2019.03.18
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// Runtime: 0 ms

package main

import "fmt"

func backtracking(result *[]string, combination string, digits []byte) {
	phone := map[byte]string{
		'1': "",
		'2': "abc",
		'3': "def",
		'4': "ghi",
		'5': "jkl",
		'6': "mno",
		'7': "pqrs",
		'8': "tuv",
		'9': "wxyz",
	}
	if len(digits) == 0 {
		*result = append(*result, combination)
	} else {
		for _, letter := range phone[digits[0]] {
			backtracking(result, combination+string(letter), digits[1:])
		}
	}
}

func letterCombinations(digits string) []string {
	result := make([]string, 0)
	if len(digits) > 0 {
		backtracking(&result, "", []byte(digits))
	}
	return result
}

func main() {
	fmt.Println(letterCombinations("23"))
	fmt.Println(letterCombinations(""))
}
