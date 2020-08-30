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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curHead = head;
        ListNode curTail = head;
        ListNode postTail = head;
        ListNode dailHead = new ListNode(-1);
        ListNode cur = dailHead;
        while(curHead != null){
            int count = k;
            try{
                while(count-- > 1){
                    curTail = curTail.next;
                }
                postTail = curTail.next;
            }catch(Exception e){
                cur.next = curHead;
                break;
            }
            curTail.next = null;
            ListNode newHead = reverse(curHead);
            cur.next = newHead;
            cur = curHead;
            curHead = postTail;
            curTail = postTail;
        }
        return dailHead.next;

    }
    public ListNode reverse(ListNode head){
        ListNode dailHead = new ListNode(-1);
        while(head != null){
            ListNode temp = head.next;
            head.next = dailHead.next;
            dailHead.next = head;
            head = temp;
        }
        return dailHead.next;
    }
}