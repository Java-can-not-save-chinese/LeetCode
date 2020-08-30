//前n项和的公式
class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] == 0) return 1;
            else return 0;
        }
        int num = 0;
        int max = -1;
        boolean existsZero = false;
        for(int i = 0; i < nums.length; i++) {
            num += nums[i];
            if (nums[i] > max) max = nums[i];
            if (nums[i] == 0) existsZero = true;
        }
        int realNum = (max * (max + 1)) / 2;
        if (!existsZero) return 0;
        return (realNum - num) == 0 ? max + 1 : realNum - num;
    }
}