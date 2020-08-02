class Solution {
    public int minMoves2(int[] nums) {
        int medium = medium(nums,nums.length /2);
        int count  = 0;
        for(int i = 0; i < nums.length; i++){
            count += Math.abs(nums[i] - medium);
        }
        return count;
    }

    //快速查找第k+1大的元素
    public int medium(int[] nums,int k){
        int start = 0, end = nums.length - 1;
        while(start < end){
            int i = start - 1,j = end;
            while(i <j){
                while(nums[++i] < nums[end] && i < end);
                while(nums[--j] > nums[end] &&  j > start);
                if(i >= j) break;
                exchange(nums,i,j);
            }
            exchange(nums,i,end);
            if(i < k){
                start = i + 1;
            }else if(i > k){
                end = i - 1;
            }else{
                return nums[i];
            }
        }
        return nums[start];
    }
    public void exchange(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}