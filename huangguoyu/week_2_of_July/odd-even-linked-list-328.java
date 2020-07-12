/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = new ListNode(head.val);
        ListNode even = new ListNode(head.next.val);
        ListNode odditem = odd;
        ListNode evenitem = even;
        int i = 1;
        while(head != null) {
            if (i <= 2) {
                i++;
                head = head.next;
                continue;
            }
            if ((i % 2) == 0) {
                evenitem.next = new ListNode(head.val);
                evenitem = evenitem.next;
            } else {
                odditem.next = new ListNode(head.val);
                odditem = odditem.next;
            }
            i++;
            head = head.next;
        }
        odditem.next = even;
        return odd;
    }
}