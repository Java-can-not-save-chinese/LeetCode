/**
    利用stack来计数链表
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp!=null) {
            stack.push(temp);
            temp = temp.next;
        }
        
        if (stack.size() == 0 || stack.size() == 1) return head;
        k = k % stack.size();
        if (k == 0) return head;

        temp = stack.pop();
        temp.next = head;
        k--;
        while(k != 0) {
            temp = stack.pop();
            k--;
        }
        stack.pop().next = null;
        return temp;
    }
}