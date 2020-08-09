package week18;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0206 {
    //Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        int i=0;

        while(head != null){
            if(i == 0){
                result = new ListNode(head.val);
                result.next = null;
            }else{
                ListNode temp = result;
                result = new ListNode(head.val);
                result.next = temp;
            }
            i++;
            head = head.next;
        }
        return result;
    }
}
