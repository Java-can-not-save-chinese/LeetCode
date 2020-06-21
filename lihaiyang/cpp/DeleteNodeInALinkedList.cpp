// DeleteNodeInALinkedList.cpp
// Author: hyan23
// 2020.06.07
// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3348/

// Runtime: 8 ms
// Memory Usage: 8.2 MB

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Definition for singly-linked list.
struct ListNode {
	int val;
	ListNode* next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
	void deleteNode(ListNode* node) {
		ListNode* tail = NULL;
		while (node->next != NULL) {
			node->val = node->next->val;
			tail = node;
			node = node->next;
		}
		tail->next = NULL;
	}
};

int main(void)
{
	return 0;
}
