/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode med = head;
        ListNode post = head.next;
        while(post != null && post.next != null){
            post = post.next.next;
            med = med.next;
        }
        ListNode newHead = med.next;
        med.next = null;
        newHead = reverseList(newHead);
        while(newHead != null && head != null){
            if(newHead.val != head.val) return false;
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode node){
        ListNode newHead = new ListNode(-1);
        while(node != null){
            ListNode next = node.next;
            node.next = newHead.next;
            newHead.next = node;
            node = next;
        }
        return newHead.next;
    }
}