class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = nums[0];
        right[length - 1] = nums[length - 1];
        for(int i = 1; i < length;i++){
            left[i] = left[i - 1] * nums[i];
            right[length - i - 1] = right[length - i] * nums[length - i - 1];
        }
        for(int i = 1; i < length - 1;i++){
            result[i] = left[i - 1] * right[i + 1];
        }
        result[0] = right[1];
        result[length - 1] = left[length - 2];
        return result;

    }
}