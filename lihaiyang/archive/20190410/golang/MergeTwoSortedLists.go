// MergeTwoSortedLists.go
// Author: hyan23
// 2019.03.20
// https://leetcode.com/problems/merge-two-sorted-lists/

// Runtime: 0 ms

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

/*
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	head := &ListNode{0, nil}
	cur := head
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			cur.Val = l1.Val
			l1 = l1.Next
		} else if l1.Val > l2.Val {
			cur.Val = l2.Val
			l2 = l2.Next
		} else {
			cur.Val = l1.Val
			cur.Next = &ListNode{l2.Val, nil}
			cur = cur.Next
			l1 = l1.Next
			l2 = l2.Next
		}
		if l1 != nil && l2 != nil {
			cur.Next = &ListNode{0, nil}
			cur = cur.Next
		}
	}
	if l1 == nil {
		cur.Next = l2
	}
	if l2 == nil {
		cur.Next = l1
	}
	return head
}
*/

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	head := l1
	prev := l1
	for l2 != nil {
		for l1 != nil && l1.Val <= l2.Val {
			prev = l1
			l1 = l1.Next
		}
		next := l2.Next
		l2.Next = l1
		if prev == l1 {
			head = l2
			prev = l2
		} else {
			prev.Next = l2
		}
		l1 = l2
		l2 = next
	}
	return head
}

func main() {

}
