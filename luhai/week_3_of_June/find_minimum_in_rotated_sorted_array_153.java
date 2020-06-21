class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while(l < h){
            int m = l + (h - l) / 2;
            if(nums[l] > nums[m] && nums[m] < nums[h]){
                h = m;;
            }else if(nums[l] < nums[m] && nums[m] > nums[h]){
                l = m + 1;
            }else{
                return Math.min(nums[m],Math.min(nums[l],nums[h]));
            }
        }
        return nums[h];
    }
}