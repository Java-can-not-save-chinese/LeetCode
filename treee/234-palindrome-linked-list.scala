/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def isPalindrome(head: ListNode): Boolean = {
        def reverse(head: ListNode, prev: ListNode): ListNode = {
            if (head == null) {
                prev
            } else {
                val next = head.next
                head.next = prev
                reverse(next, head)
            }
        }
        
        if (head == null) {
            return true
        }

        var fast = head
        var slow = head

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next
            slow = slow.next
        }

        slow = reverse(slow, null)

        fast = head
        while (slow != null && fast != null) {
            if (slow.x != fast.x) {
                return false
            }
            slow = slow.next
            fast = fast.next
        }

        true
    }
}
