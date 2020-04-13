// RemoveElement.go
// Author: hyan23
// 2019.04.07
// https://leetcode.com/problems/remove-element/

// Runtime: 0 ms

package main

import "fmt"

func removeElement(nums []int, val int) int {
	if len(nums) == 0 {
		return 0
	}
	i, j := 0, 0
	for ; j < len(nums); j++ {
		if nums[j] != val {
			nums[i] = nums[j]
			i++
		}
	}
	return i
}

func main() {
	fmt.Println(removeDuplicates([]int{3, 2, 2, 3}, 3))
	fmt.Println(removeDuplicates([]int{0, 1, 2, 2, 3, 0, 4, 2}, 2))
}
