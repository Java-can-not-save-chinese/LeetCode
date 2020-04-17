// 3Sum.go
// Author: hyan23
// 2019.03.10
// https://leetcode.com/problems/3sum/
// 我的解法太蠢了

// Runtime: 1556 ms (10.93% faster)
// Best solution: 764 ms

package main

import (
	"fmt"
	"sort"
)

func threeSum(nums []int) [][]int {
	result := make(map[[3]int]bool)

	mp := make(map[int]bool)
	mp2 := make(map[int]int)
	for _, val := range nums {
		if _, ok := mp[val]; ok {
			mp2[val]++
		} else {
			mp[val] = true
			mp2[val] = 1
		}
	}

	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			sum := nums[i] + nums[j]
			_, ok := mp[-sum]
			num, ok2 := mp2[-sum]
			target := 0
			if -sum == nums[i] {
				target++
			}
			if -sum == nums[j] {
				target++
			}
			// fmt.Printf("%v %v\n", nums[i], nums[j])
			if ok && (!(target > 0) || ok2 && num > target) {
				tri := []int{nums[i], nums[j], -sum}
				sort.Ints(tri)
				triplet := [3]int{tri[0], tri[1], tri[2]}
				if _, ok := result[triplet]; !ok {
					result[triplet] = true
				}
			}
		}
	}

	re := make([][]int, 0, len(result))
	for key, _ := range result {
		re = append(re, []int{key[0], key[1], key[2]})
	}
	return re
}

func main() {
	fmt.Printf("%v\n", threeSum([]int{-1, 0, 1, 2, -1, -4}))
	fmt.Printf("%v\n", threeSum([]int{3, 13, 8, -8, -15, -3, 13, -3, -12, -7, 2, -3, -8, 10, 0, -12, 5, 13, 13, 8, 6, -11, 6, -10, -13, 14, -9, 9, 5, 7, 12, -14, 5, -3, -7, -3, 10, 13, 9, 5, 13, -4, -12, -9, 13, -5, -14, 3, -7, 6, -12, 7, 10, 10, 12, 12, 9, 10, -2, -9, 2, -5, -8, 14, 0, -8, -4, -13, 12, 12, 7, 11, -15, 2, -13, 5, 12, 10, -14, 13, 1, -11, -3, -12, 14, -6, -15, 8, 11, -10, 7, -10, -7, 14, 11, 8, 14, 14, 10, 11, 11, -6}))
	fmt.Printf("%v\n", threeSum([]int{0, 0}))
	fmt.Printf("%v\n", threeSum([]int{-1, 0, 1, 0}))
	fmt.Printf("%v\n", threeSum([]int{1, 2, -2, -1}))
}
