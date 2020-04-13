// SwapNodesInPairs.go
// Author: hyan23
// 2019.02.23
// https://leetcode.com/problems/swap-nodes-in-pairs/

// Runtime: 0 ms

package main

import "fmt"

func swapPairs(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	cur := head
	secondNode := head.Next
	for {
		first := cur
		if first == nil {
			break
		}
		cur = cur.Next
		second := cur
		if second == nil {
			break
		}
		cur = cur.Next
		first.Next = second.Next
		if first.Next != nil && first.Next.Next != nil {
			first.Next = first.Next.Next
		}
		second.Next = first
	}
	if secondNode != nil {
		return secondNode
	} else {
		return head
	}
}

func main() {
	l := toLinkedList([]int{1, 2, 3, 4})
	fmt.Println(toList(swapPairs(l)))
	l2 := toLinkedList([]int{1, 2, 3, 4, 5})
	fmt.Println(toList(swapPairs(l2)))
	l3 := toLinkedList([]int{})
	fmt.Println(toList(swapPairs(l3)))
	l4 := toLinkedList([]int{1})
	fmt.Println(toList(swapPairs(l4)))
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func toLinkedList(arr []int) *ListNode {
	var head, cur *ListNode = nil, nil
	for i, val := range arr {
		if i == 0 {
			head = &ListNode{val, nil}
			cur = head
		} else {
			cur.Next = &ListNode{val, nil}
			cur = cur.Next
		}
	}
	return head
}

func toList(head *ListNode) []int {
	arr := []int{}
	for head != nil {
		arr = append(arr, head.Val)
		head = head.Next
	}
	return arr
}
