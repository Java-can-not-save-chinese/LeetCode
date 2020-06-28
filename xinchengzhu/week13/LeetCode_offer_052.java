package week13;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_offer_052 {

  public class ListNode {
      int val;
      ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
     }
  }

    /**
     *
     * @param headA
     * @param headB
     * @return
     *
     * 要在这2个链表中找到共同节点，就相当于初中物理中的 A 追 B
     * 把A 和 B 的位置想象成 一个圈上的2个不同的点
     * A 在 B 后面， A 想要追上B 就需要先走完和 B 相差的那段距离
     * 链表 A 的长度 + 链表 B 的长度  = 整个圈的长度
     * A 和 B 长度差就为 A 和 B 的距离
     * 总有一个人先走完一圈，当A 和B 相遇时，那个节点就为 第一个共同节点
     *
     *
     *
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != pb){
            pa = pa == null ? headB: pa.next;
            pb = pb == null ? headA : pb.next;
        }

        return pa;
    }
}
