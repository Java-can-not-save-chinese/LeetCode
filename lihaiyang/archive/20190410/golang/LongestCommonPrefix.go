// LongestCommonPrefix.go
// Author: hyan23
// 2019.03.10
// https://leetcode.com/problems/longest-common-prefix/

// Runtime: 0 ms

package main

import (
	"fmt"
)

func longestCommonPrefix(strs []string) string {
	prefix := ""
	pos := 0
	for len(strs) > 0 {
		match := true
		var letter byte = '#'
		for _, str := range strs {
			if pos == len(str) {
				match = false
				break
			}
			if letter == '#' {
				letter = str[pos]
			}
			if str[pos] != letter {
				match = false
				break
			}
		}
		if match {
			prefix = prefix + string(letter)
		} else {
			break
		}
		pos++
	}
	return prefix
}

func main() {
	fmt.Println(longestCommonPrefix([]string{"flower", "flow", "flight"}))
	fmt.Println(longestCommonPrefix([]string{"dog", "racecar", "car"}))
	fmt.Println(longestCommonPrefix([]string{}))
}
