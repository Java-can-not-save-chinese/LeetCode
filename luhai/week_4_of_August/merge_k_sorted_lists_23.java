/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode temp;
        while((temp = minHead(lists)) != null){
            cur.next = temp;
            cur = cur.next;
        }
        return head.next;
    }
    public ListNode minHead(ListNode[] lists){
        int min = Integer.MAX_VALUE;
        int index = -1;
        ListNode result = null;
        for(int i = 0; i < lists.length;i++){
            ListNode listNode = lists[i];
            if(listNode != null && listNode.val < min){
                min = listNode.val;
                result = listNode;
                index = i;
            }
        }
        if (result !=null)
            lists[index] = lists[index].next;
        return result;
    }
}