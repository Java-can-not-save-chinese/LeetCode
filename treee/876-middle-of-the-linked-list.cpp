/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        if (head->next == nullptr)
            return head;
        
        ListNode *fast = head->next, *slow = head;
        while (fast) {
            slow = slow->next;
            if (fast->next == nullptr)
                return slow;
            fast = fast->next;
            if (fast->next == nullptr)
                return slow;
            fast = fast->next;
        }
        return slow;
    }
};