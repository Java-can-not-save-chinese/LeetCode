// LongestValidParentheses.go
// Author: hyan23
// 2019.04.10
// https://leetcode.com/problems/longest-valid-parentheses/

// Runtime: 0 ms (100% faster)

package main

import (
	"fmt"
)

func longestValidParentheses(s string) int {
	maxLength := 0
	sta := []int{}
	broken := 0
	for i, ch := range s {
		if ch == '(' {
			sta = append(sta, i+1)
		} else if ch == ')' {
			if len(sta) > 0 {
				sta = sta[:len(sta)-1]
				length := i + 1 - broken
				if len(sta) > 0 {
					length -= sta[len(sta)-1] - broken
				}
				if length > maxLength {
					maxLength = length
				}
			} else {
				broken = i + 1
			}
		}
	}
	return maxLength
}

func main() {
	fmt.Println(longestValidParentheses("(()"))
	fmt.Println(longestValidParentheses(")()()"))
	fmt.Println(longestValidParentheses("((((((()"))
	fmt.Println(longestValidParentheses("((((((()))))))"))
	fmt.Println(longestValidParentheses("())))))"))
	fmt.Println(longestValidParentheses("()))()())))"))
	fmt.Println(longestValidParentheses("()(()"))
	fmt.Println(longestValidParentheses(")(((((()())()()))()(()))("))
	fmt.Println(longestValidParentheses(""))
}
