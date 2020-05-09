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
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr || head->next == nullptr)
            return head;
        
        ListNode* p = head->next;
        head->next = p->next;
        p->next = head;
        head = p;
        
        p = head->next;
        
        while (p->next && p->next->next) {
            ListNode* q = p->next;
            p->next = q->next;
            q->next = p->next->next;
            p->next->next = q;
            
            p = p->next->next;
        }
        
        return head;
    }
};