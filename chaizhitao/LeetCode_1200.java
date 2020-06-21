1200. 最小绝对差
给你个整数数组 arr，其中每个元素都 不相同。

请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。

 

示例 1：

输入：arr = [4,2,1,3]
输出：[[1,2],[2,3],[3,4]]
示例 2：

输入：arr = [1,3,6,10,15]
输出：[[1,3]]
示例 3：

输入：arr = [3,8,-10,23,19,-4,-14,27]
输出：[[-14,-10],[19,23],[23,27]]

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int l = arr.length;
        int min = arr[l-1] - arr[0];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < l; i++) {
            min = Math.min(min, arr[i] - arr[i-1]);
        }
        for (int i = 1; i < l; i++) {
            List<Integer> pair = new ArrayList<>();
            if (min == arr[i] - arr[i-1]) {
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                res.add(pair);
            }
        }
        return res;
    }
}
