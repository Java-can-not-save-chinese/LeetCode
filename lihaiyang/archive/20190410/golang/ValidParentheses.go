// ValidParentheses.go
// Author: hyan23
// 2019.03.19
// https://leetcode.com/problems/valid-parentheses/

// Runtime: 0 ms

package main

import "fmt"

func isValid(s string) bool {
	partner := map[rune]rune{
		')': '(',
		']': '[',
		'}': '{',
	}
	sta := make([]rune, 0)
	for _, ch := range s {
		if ch == '(' || ch == '[' || ch == '{' {
			sta = append(sta, ch)
		} else if ch == ')' || ch == ']' || ch == '}' {
			if len(sta) > 0 {
				if sta[len(sta)-1] != partner[ch] {
					return false
				}
				sta = sta[0 : len(sta)-1]
			} else {
				return false
			}
		}
	}
	if len(sta) > 0 {
		return false
	} else {
		return true
	}
}

func main() {
	fmt.Println(isValid("()"))
	fmt.Println(isValid("()[]{}"))
	fmt.Println(isValid("(]"))
	fmt.Println(isValid("([)]"))
	fmt.Println(isValid("{[]}"))
	fmt.Println(isValid(""))
}
