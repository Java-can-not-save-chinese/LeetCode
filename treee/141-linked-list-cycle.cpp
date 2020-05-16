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
    bool hasCycle(ListNode *head) {
        if (head == nullptr || head->next == nullptr)
            return false;
        
        ListNode *fast = head;
        ListNode *low = head;
        while (fast) {
            fast = fast->next;
            if (fast)
                fast = fast->next;
            low = low->next;
            if (fast == low)
                return true;
        }
        
        return false;
    }
};