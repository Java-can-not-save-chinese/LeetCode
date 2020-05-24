package week08;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/21 21:28
 */
public class LeetCode_148 {


    public static void main(String[] args) {

        ListNode node = new ListNode(6);
        node.next = new ListNode(5);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(1);

        ListNode listNode = sortList(node);

        System.out.println(listNode);
    }


    /**
     * 归并排序，快慢指针进行链表的分割， 把分割后的链表进行排序，最后归并。
     */
    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        //快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }

        ListNode subNode = slow.next;
        //断链
        slow.next = null;
        //割
        ListNode left = sortList(head);
        ListNode right = sortList(subNode);
        //合并
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        while (left != null && right != null) {
            if (left.val > right.val) {
                curNode.next = new ListNode(right.val);
                right = right.next;
            } else {
                curNode.next = new ListNode(left.val);
                left = left.next;
            }
            curNode = curNode.next;
        }

        if (left != null) {
            curNode.next = left;
        }
        if (right != null) {
            curNode.next = right;

        }

        return head.next;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
