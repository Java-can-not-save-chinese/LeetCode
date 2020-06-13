package LeetCode.xinchengzhu.week11;


import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 *
 */
public class LeetCode_Interview012 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        System.out.println(reversePrint(listNode));

    }


    public static int[] reversePrint(ListNode head) {
        Stack stack = new Stack();

        while (head != null){
            stack.push(head.val);
            head = head.next;
        }

        int []result = new int[stack.size()];
        int i=0;
        while (!stack.isEmpty()){
            result[i] = (int)stack.pop();
            i++;
        }

        return result;
    }
}
