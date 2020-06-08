/**
1.遍历累加相邻两点递减次数，设为d。
2.遍历累加间隔一点的前后两点递减次数，设为g。
3.如果d或g为2，则为False，反之为True。
*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        int d=0;
        int g=0;
        for (int i = 0; i < (nums.length - 1); i++) {
            if (i-1>=0 && i+1<=nums.length-1 && nums[i-1]>nums[i+1])
                g+=1;
            if (nums[i]>nums[i+1])
                d+=1;
            if (d>=2 || g>=2)
                return false;
        }
        return true;
    }

}