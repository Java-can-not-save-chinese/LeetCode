package week07;


public class LeetCode_203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode s = new ListNode(0);
        s.next = head;
        ListNode prev = s, curr = head;

        while (curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            }else {
                prev = curr;
            }
            curr = curr.next;
        }

        return s.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
