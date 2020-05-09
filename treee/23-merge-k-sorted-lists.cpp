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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if (lists.size() == 0)
            return nullptr;
        priority_queue<int, vector<int>, greater<int>> que;
        for (auto&& l : lists) {
            while (l) {
                que.push(l->val);
                l = l->next;
            }
        }
        
        ListNode* ret = new ListNode();
        ListNode* p = ret;
        
        while (!que.empty()) {
            ListNode* node = new ListNode(que.top());
            que.pop();
            p->next = node;
            p = p->next;
        }
        
        return ret->next;
    }
};