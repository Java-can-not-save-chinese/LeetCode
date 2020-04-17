// CountAndSay.go
// Author: hyan23
// 2019.08.21
// https://leetcode.com/problems/count-and-say/

/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
Note: Each term of the sequence of integers will be represented as a string.

Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"
*/

/*
Runtime: 0 ms, faster than 100.00% of Go online submissions for Count and Say.
Memory Usage: 6.6 MB, less than 33.33% of Go online submissions for Count and Say.
*/

package main

import (
	"fmt"
	"strconv"
)

func countAndSay(n int) string {
	term := "1"
	for i := 1; i < n; i++ {
		newTerm := ""
		cur := byte(0)
		count := int64(0)
		for j := 0; j < len(term); j++ {
			ch := term[j]
			if ch != cur {
				if cur != 0 {
					newTerm += strconv.FormatInt(count, 10) + string(cur)
				}
				cur = ch
				count = 1
			} else {
				count++
			}
			if j == len(term)-1 {
				newTerm += strconv.FormatInt(count, 10) + string(cur)
			}
		}
		term = newTerm
	}
	return term
}

func main() {
	for i := 1; i <= 10; i++ {
		fmt.Println(countAndSay(i))
	}
}
