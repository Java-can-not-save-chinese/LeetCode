/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def oddEvenList(head: ListNode): ListNode = {
        if (head == null || head.next == null || head.next.next == null) {
            return head
        }

        val ret: ListNode = head
        var p: ListNode = head
        var odd: ListNode = head
        val q: ListNode = head.next
        var even: ListNode = head.next
        p = p.next.next

        while (p != null) {
            odd.next = p
            odd = odd.next
            p = p.next
            if (p != null) {
                even.next = p
                p = p.next
                even = even.next
            }
        }

        odd.next = q
        even.next = null

        ret
    }
}
