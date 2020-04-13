// FindFirstAndLastPosition.go
// Author: hyan23
// 2019.08.08
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

/**
Runtime: 8 ms, faster than 85.27% of Go online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 4.1 MB, less than 50.00% of Go online submissions for Find First and Last Position of Element in Sorted Array.
*/

package main

import "fmt"

func searchRange(nums []int, target int) []int {
	result := []int{-1, -1}
	helper(nums, target, 0, len(nums)-1, &result)
	return result
}

func helper(div []int, target int, leftIdx int, rightIdx int, result *[]int) {
	if len(div) == 0 {
	} else if len(div) == 1 {
		if div[0] == target {
			if leftIdx < (*result)[0] || (*result)[0] == -1 {
				(*result)[0] = leftIdx
			}
			if rightIdx > (*result)[1] || (*result)[1] == -1 {
				(*result)[1] = leftIdx
			}
		}
	} else {
		if div[0] <= target && div[len(div)-1] >= target {
			mid := len(div) / 2
			helper(div[0:mid], target, leftIdx, leftIdx+mid-1, result)
			helper(div[mid:], target, leftIdx+mid, rightIdx, result)
		}
	}
}

func main() {
	fmt.Println(searchRange([]int{5, 7, 7, 8, 8, 10}, 8))
	fmt.Println(searchRange([]int{5, 7, 7, 8, 8, 10}, 6))
	fmt.Println(searchRange([]int{5, 7, 7, 8, 9, 10}, 8))
	fmt.Println(searchRange([]int{8, 8, 8, 8, 8, 8}, 8))
}
