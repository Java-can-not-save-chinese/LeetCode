// 3SumClosest.go
// Author: hyan23
// 2019.03.11
// https://leetcode.com/problems/3sum-closest/

// Runtime: 4 ms (95.92% faster)
// Best solution: 0 ms

package main

import (
	"fmt"
	"sort"
)

func tripletSum(triplet [3]int) int {
	return triplet[0] + triplet[1] + triplet[2]
}

func abs(x int) int {
	if x > 0 {
		return x
	} else {
		return -x
	}
}

func threeSumClosest(nums []int, target int) int {
	triplet := [3]int{nums[0], nums[1], nums[2]}
	sum := tripletSum(triplet)
	distance := abs(target - sum)
	sort.Ints(nums)
	for i := range nums {
		left, right := i+1, len(nums)-1
		for left < right {
			triplet2 := [3]int{nums[i], nums[left], nums[right]}
			sum2 := tripletSum(triplet2)
			distance2 := abs(target - sum2)
			if distance2 < distance {
				distance = distance2
				sum = sum2
			}
			if sum2 > target {
				right--
			} else {
				left++
			}
		}
	}
	return sum
}

func main() {
	fmt.Println(threeSumClosest([]int{-1, 2, 1, -4}, 1))
	fmt.Println(threeSumClosest([]int{1, 1, 1, 0}, -100))
	fmt.Println(threeSumClosest([]int{1, 2, 4, 8, 16, 32, 64, 128}, 82))
}
