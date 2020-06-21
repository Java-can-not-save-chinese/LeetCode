/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        while(head != null) {
            stack.push(head.val);
            n++;
            head = head.next;
        }
        int res[] = new int[n];
        n = 0;
        while(!stack.isEmpty()) {
            res[n++] = stack.pop();
        }
        return res;
    }
}