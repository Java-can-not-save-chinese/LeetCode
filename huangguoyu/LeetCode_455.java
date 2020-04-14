/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //O(n)
        int s1 = getListSize(l1);
        int s2 = getListSize(l2);

        //确定索引startIndex 
        ListNode temp = l1;
        int q1, q2 = 0;
        if (s1 > s2) {
            q1 = s1 - s2;
        } else {
            q1 = s2 - s1;
            l1 = l2;
            l2 = temp;
        }
        temp = l1;
        

        //第一次遍历求和 O(n)
        for(int i = 0; l1 != null || l2 != null; i++) {
            if (q1 == q2) {
                if (l1 == null) {
                    l1 = l2;
                    break;
                }
                if (l2 == null) {
                    break;
                }
                l1.val += l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (q1 > 0) {
                q1--;
                l1 = l1.next;
            } else if (q2 > 0) {
                q2--;
                l2 = l2.next;
            }
        }

        //递归得到结果 O(n)
        ListNode res = dfs(temp);
        if (res == null) {
            return temp;
        } else {
            res.next = temp;
            return res;
        }

    }


    public ListNode dfs(ListNode node) {
        ListNode root;
        if (node == null)
            return null;
        root = dfs(node.next);

        //进位
        if (root != null) {
            node.val += root.val;
        }

        if(node.val > 9) {
            root = new ListNode(node.val / 10);
            node.val %= 10;
            return root;
        } 
        return null;
    } 


    public int getListSize(ListNode l) {
        int res = 0;
        while(l != null) {
            res++;
            l = l.next;
        }
        return res;
    }
}