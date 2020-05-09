/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (head == nullptr || n == 0)
            return head;
        
        ListNode *fast = head, *low = head;
        for (int i = 0; i < n; ++i) {
            fast = fast->next;
        }
        if (fast)
            fast = fast->next;
        else
            return head->next;
        
        while (fast) {
            fast = fast->next;
            low = low->next;
        }
        low->next = low->next->next;
        
        return head;
    }
};