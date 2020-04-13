// RemoveNthNode.go
// Author: hyan23
// 2019.03.18
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

// Runtime: 0 ms

package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	if head == nil || n == 0 {
		return head
	}
	if head.Next == nil {
		head.Val = n
		return nil
	} else {
		Val2 := head.Next.Val
		head.Next.Val = 0
		removeNthFromEnd(head.Next, n)
		Val3 := head.Next.Val
		if Val3 == 1 {
			head.Next = head.Next.Next
		} else {
			if Val3 > 1 {
				head.Val = head.Next.Val - 1
			}
			head.Next.Val = Val2
		}
		if Val3 == 2 {
			return head.Next
		} else {
			return head
		}
	}
}

func printLinkedList(head *ListNode) {
	if head == nil {
		return
	}
	fmt.Printf("%v ", head.Val)
	printLinkedList(head.Next)
}

func main() {
	head := ListNode{1, nil}
	head.Next = &ListNode{2, nil}
	printLinkedList(removeNthFromEnd(&head, 2))
}
