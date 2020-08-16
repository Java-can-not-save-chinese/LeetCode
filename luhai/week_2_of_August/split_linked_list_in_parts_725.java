/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = length(root);
        int[] lengths = new int[k];
        Arrays.fill(lengths,size / k);
        for(int i = 0; i < size % k;i++){
            lengths[i] ++;
        }
        ListNode[] result = new ListNode[k];
        for(int i = 0; i < k;i++){
            if(lengths[i] == 0){
                return result;
            }
            result[i] = root;
            for(int j = 0; j < lengths[i] - 1;j++){
                root = root.next;
            }
            ListNode temp = root.next;
            root.next = null;
            root = temp;
        }
        return result;
    }

    public int length(ListNode root){
        int result = 0;
        while(root != null){
            root = root.next;
            result += 1;
        }
        return result;
    }
}