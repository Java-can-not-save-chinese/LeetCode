// MergeKSortedLists.go
// Author: hyan23
// 2019.03.21
// https://leetcode.com/problems/merge-k-sorted-lists/

// Runtime: 12 ms (75.61% faster)
// Best solution: 0 ms

package main

import (
	"container/heap"
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

/*
func minNode(lists []*ListNode) int {
	minVal, minIdx := 0, -1
	first := true
	for i, node := range lists {
		if node != nil {
			if first {
				minVal = node.Val
				minIdx = i
				first = false
			} else {
				if node.Val < minVal {
					minVal = node.Val
					minIdx = i
				}
			}
		}
	}
	return minIdx
}

func mergeKLists(lists []*ListNode) *ListNode {
	var head, cur *ListNode = nil, nil
	first := true
	for minIdx := minNode(lists); minIdx != -1; minIdx = minNode(lists) {
		node := lists[minIdx]
		if first {
			head = &ListNode{node.Val, nil}
			cur = head
			first = false
		} else {
			cur.Next = &ListNode{node.Val, nil}
			cur = cur.Next
		}
		lists[minIdx] = node.Next
		if lists[minIdx] == nil {
			lists = append(lists[:minIdx], lists[minIdx+1:]...)
		}
	}
	return head
}
*/

/*
type NodeSlice []*ListNode

func (ns *NodeSlice) Len() int {
	return len(*ns)
}

func (ns *NodeSlice) Less(i, j int) bool {
	if (*ns)[i] == nil {
		return false
	}
	if (*ns)[j] == nil {
		return true
	}
	return (*ns)[i].Val < (*ns)[j].Val
}

func (ns *NodeSlice) Swap(i, j int) {
	(*ns)[i], (*ns)[j] = (*ns)[j], (*ns)[i]
}

func mergeKLists(lists []*ListNode) *ListNode {
	var ns NodeSlice = lists
	var head, cur *ListNode = nil, nil
	first := true
	for sort.Sort(&ns); len(ns) > 0; sort.Sort(&ns) {
		for len(ns) > 0 && ns[len(ns)-1] == nil {
			ns = ns[0 : len(ns)-1]
		}
		if len(ns) > 0 {
			if first {
				head = &ListNode{ns[0].Val, nil}
				cur = head
				first = false
			} else {
				cur.Next = &ListNode{ns[0].Val, nil}
				cur = cur.Next
			}
			ns[0] = ns[0].Next
		}
	}
	return head
}
*/

type NodeSlice []*ListNode

func (ns *NodeSlice) Len() int {
	return len(*ns)
}

func (ns *NodeSlice) Less(i, j int) bool {
	if (*ns)[i] == nil {
		return false
	}
	if (*ns)[j] == nil {
		return true
	}
	return (*ns)[i].Val < (*ns)[j].Val
}

func (ns *NodeSlice) Swap(i, j int) {
	(*ns)[i], (*ns)[j] = (*ns)[j], (*ns)[i]
}

func (ns *NodeSlice) Push(x interface{}) {
	(*ns) = append(*ns, x.(*ListNode))
}

func (ns *NodeSlice) Pop() (x interface{}) {
	x = (*ns)[len(*ns)-1]
	(*ns) = (*ns)[:len(*ns)-1]
	return
}

func mergeKLists(lists []*ListNode) *ListNode {
	var head, cur *ListNode = nil, nil
	first := true
	var ns NodeSlice = lists
	heap.Init(&ns)
	for len(ns) > 0 && ns[0] != nil {
		if first {
			head = &ListNode{ns[0].Val, nil}
			cur = head
			first = false
		} else {
			cur.Next = &ListNode{ns[0].Val, nil}
			cur = cur.Next
		}
		ns[0] = ns[0].Next
		heap.Fix(&ns, 0)
	}
	return head
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

func main() {
	/*
		l1 := toLinkedList([]int{1, 4, 5})
		l2 := toLinkedList([]int{1, 3, 4})
		l3 := toLinkedList([]int{2, 6})
		lists := []*ListNode{l1, l2, l3}
		result := toList(mergeKLists(lists))
		fmt.Println(result)
	*/
	/*
		l1 := toLinkedList([]int{})
		l2 := toLinkedList([]int{-1, 5, 11})
		l3 := toLinkedList([]int{})
		l4 := toLinkedList([]int{6, 10})
		lists := []*ListNode{l1, l2, l3, l4}
		result := toList(mergeKLists(lists))
		fmt.Println(result)
	*/
	l1 := toLinkedList([]int{-8, -7, -7, -5, 1, 1, 3, 4})
	l2 := toLinkedList([]int{-2})
	l3 := toLinkedList([]int{-10, -10, -7, 0, 1, 3})
	l4 := toLinkedList([]int{2})
	lists := []*ListNode{l1, l2, l3, l4}
	result := toList(mergeKLists(lists))
	fmt.Println(result)
}
