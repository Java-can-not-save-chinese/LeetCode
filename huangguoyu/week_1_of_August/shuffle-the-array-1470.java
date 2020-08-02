class Solution {
    public int[] shuffle(int[] nums, int n) {
        int temp[] = new int[nums.length];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            temp[idx] = nums[i];
            temp[idx + 1] = nums[i + n];
            idx += 2;
        }
        return temp;
    }
}