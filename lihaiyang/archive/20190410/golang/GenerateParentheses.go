// GenerateParentheses.go
// Author: hyan23
// 2019.03.21
// https://leetcode.com/problems/generate-parentheses/

// Runtime: 4 ms (96.23% faster)
// Best solution: 0 ms

package main

import "fmt"

func helper(result *[]string, parentheses string, leftLeft int, leftAvlLeft int, rigthLeft int) {
	if leftLeft+rigthLeft == 0 {
		*result = append(*result, parentheses)
	}
	if leftLeft > 0 {
		helper(result, parentheses+"(", leftLeft-1, leftAvlLeft+1, rigthLeft)
	}
	if leftAvlLeft > 0 && rigthLeft > 0 {
		helper(result, parentheses+")", leftLeft, leftAvlLeft-1, rigthLeft-1)
	}
}

func generateParenthesis(n int) []string {
	if n > 0 {
		result := []string{}
		helper(&result, "", n, 0, n)
		return result
	} else {
		return nil
	}
}

func main() {
	fmt.Println(generateParenthesis(3))
	fmt.Println(generateParenthesis(0))
	fmt.Println(generateParenthesis(1))
}
