/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 计数统计可以用hashMap（统计数组每个数字出现次数）
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        inOrder(root);
        List<Integer> list = new ArrayList<>();
         Integer max = 0;
         for (Map.Entry<Integer, Integer> item: map.entrySet()) {
            Integer k = item.getKey();
            Integer v = item.getValue();
            if (v > max) {
                list.clear();
                list.add(k);
                max = v;
            }
            else if (v == max) list.add(k);
         }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void inOrder(TreeNode node) {
        if(node != null) {
            inOrder(node.left);
            if(map.get(node.val) != null) {
                map.put(node.val, map.get(node.val) + 1);
            } else {
                map.put(node.val, 1);
            }
            inOrder(node.right);
        }
    }
}