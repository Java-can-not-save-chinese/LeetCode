package LeetCode.xinchengzhu.week8;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class LeetCode_234 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-192);
        head.next = new ListNode(-192);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if(head == null){
            return true;
        }
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        int start = 0;
        int end = list.size()-1;

        while (start < end){
            if(list.get(start).compareTo(list.get(end)) == 0){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
