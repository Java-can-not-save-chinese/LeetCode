class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int start = 0,end = nums.length - 1;
        while(start <= end){
            int index = start - 1;
            for(int i = start; i <= end; i++){
                if(nums[i] <= nums[end]){
                    exchange(nums,++index,i);
                }
            }
            if(index == k){
                return nums[k];
            }else if(index < k){
                start = index + 1;
            }else{
                end = index - 1;
            }
        }
        return 0;
    }
    public void exchange(int[] nums,int i, int j){
        if(i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}