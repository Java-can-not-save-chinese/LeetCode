package week12;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_offer_025 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);

        mergeTwoLists(l1, l2);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        ListNode head = result;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        if(l1 == null){
            head.next = l2;
        }else if(l2 ==null){
            head.next = l1;
        }
        return result.next;
    }
}
