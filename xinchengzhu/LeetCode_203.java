package LeetCode.xinchengzhu;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
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
