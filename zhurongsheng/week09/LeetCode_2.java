package week09;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/25 19:43
 */
public class LeetCode_2 {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;

        while (p != null || q != null) {
            int v1 = p != null ? p.val : 0;
            int v2 = q != null ? q.val : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }

        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return result.next;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
