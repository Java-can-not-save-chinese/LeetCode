/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head.next;
        ListNode next = swapPairs(pre.next);
        pre.next = head;
        head.next = next;
        return pre;
    }
}