// .go
// Author: hyan23
// <yyyy.mm.dd>
// <problem url>

// <Analysis>

package main

func main() {

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
