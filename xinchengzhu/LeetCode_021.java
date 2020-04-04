package LeetCode.xinchengzhu;

public class LeetCode_021 {

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode result;
        ListNode returnResult;
        if(l1 == null && l2 == null){
            return l1;
        }else if(l1 != null && l2 == null){
            return l1;
        }else if( l1 == null && l2 != null){
            return l2;
        }



        if(p1.val < p2.val){
            result = new ListNode(p1.val);
            p1 = p1.next;
        }else {
            result = new ListNode(p2.val);
            p2 = p2.next;
        }
        returnResult = result;

        while (p1 != null || p2 != null){
            if(p1 != null && p2 != null){
                if(p1.val < p2.val){
                    result.next = new ListNode(p1.val);
                    result = result.next;
                    p1 = p1.next;
                }else {
                    result.next = new ListNode(p2.val);
                    result = result.next;
                    p2 = p2.next;
                }
            }else if(p1 != null && p2 == null){
                result.next = new ListNode(p1.val);
                result = result.next;
                p1 = p1.next;
            }else if(p1 == null && p2 != null){
                result.next = new ListNode(p2.val);
                result = result.next;
                p2 = p2.next;
            }

        }



        return returnResult;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        ListNode reult = new ListNode(-1);

        ListNode pre = reult;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
                pre = pre.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
                pre = pre.next;
            }
        }

        pre.next = l1 == null?l2:l1;
        return reult.next;
    }

   public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }
}
