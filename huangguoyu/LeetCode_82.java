/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode q, s;
        q = head;

        if (head == null || head.next == null) return head;


        // 找到头结点
        boolean flag = false;
        boolean isDup = true;
        while(isDup) {
            while(q.val == q.next.val) {
                q = q.next;
                flag = true;
                if (q.next == null) return null;
            }
            if (flag) {
                q = q.next;
                if (q.next == null) return q;
                flag = false;
            } else  {
                isDup = false;
            }
        }
        
        head = new ListNode(q.val);
        ListNode temp = head;
        s = q.next;

        // 删除重复
        while(s != null) {
            if (s.next == null) {
                temp.next = new ListNode(s.val);
                break;
            }
            flag = false;
            while(s.val == s.next.val) {
                s = s.next;
                flag = true;
                if (s.next == null) break;
            }
            if (flag) {
                s = s.next;
                continue;
            } else {
                temp.next = new ListNode(s.val);
                temp = temp.next;
                s = s.next;
            }
            
        }

        return head;
    }
}