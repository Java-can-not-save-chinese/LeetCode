/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        Stack<Integer> stack = new Stack<>();
        int n = 0;
        while(head != null) {
            stack.push(head.val);
            n++;
            head = head.next;
        }
        ListNode res = new ListNode(stack.pop());
        ListNode item = res;
        while(!stack.isEmpty()) {
            item.next = new ListNode(stack.pop());
            item = item.next;
        }
        return res;
    }
}