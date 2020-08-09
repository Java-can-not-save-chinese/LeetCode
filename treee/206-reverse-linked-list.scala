/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseList(head: ListNode): ListNode = {
        def reverse(head: ListNode, prev: ListNode): ListNode = {
            if (head == null) {
                prev
            } else {
                val next = head.next
                head.next = prev
                reverse(next, head)
            }
        }

        reverse(head, null)
    }

    def reverseList(head: ListNode): ListNode = {
        var prev: ListNode = null
        var h = head

        while (h != null) {
            var next = h.next
            h.next = prev
            prev = h
            h = next
        }

        prev
    }
}