class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        if(length == 1) return nums[0];
        if(length == 2) return Math.max(nums[0],nums[1]);
        return Math.max(dp(nums,0,length - 2),dp(nums,1,length - 1));

    }
    private int dp(int[] nums,int start,int end){
        int[] result = new int[end - start + 1];
        result[0] = nums[start];
        result[1] = Math.max(nums[start],nums[start + 1]);
        for(int i = start + 2; i <= end;i++){
            result[i - start] = Math.max(result[i - start - 2] + nums[i],result[i -start - 1]);
        }
        return result[end - start];
    }
}