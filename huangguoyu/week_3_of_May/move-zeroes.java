
// 两次for即可
// 1. 拷贝所有的非0
// 2. copy整个数组
class Solution {
    public void moveZeroes(int[] nums) {
        int res[] = new int[nums.length];
        int inx = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) res[inx++] = nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}