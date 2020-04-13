// RemoveDuplidates.go
// Author: hyan23
// 2019.04.07
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// Runtime: 44 ms (85.75% faster)
// Best solution: 28 ms

package main

import "fmt"

func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	i, j := 0, 1
	for ; j < len(nums); j++ {
		if nums[i] != nums[j] {
			i++
			nums[i] = nums[j]
		}
	}
	return i + 1
}

func main() {
	fmt.Println(removeDuplicates([]int{1, 1, 2}))
	fmt.Println(removeDuplicates([]int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}))
}
