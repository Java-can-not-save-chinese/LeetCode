package week09;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/25 19:43
 */
public class LeetCode_234 {


    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        //1 快慢指针
        while (fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }
        //2 断链
        ListNode successor = slow.next;
        slow.next = null;
        //3 翻转节点
        ListNode reverse = reverse(successor);
        //4 比较
        while (reverse != null && head != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            //移动指针
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return pre;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
