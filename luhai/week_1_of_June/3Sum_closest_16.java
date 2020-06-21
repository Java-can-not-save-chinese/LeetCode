class Solution {
    //Violent search
    public int threeSumClosest(int[] nums, int target) {
        int gap = Integer.MAX_VALUE, result = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int sum2 = nums[i] + nums[j];
                for(int k = j + 1; k < nums.length; k++){
                    int sum3 = sum2 + nums[k];
                    if(Math.abs(sum3 - target) < gap){
                        gap = Math.abs(sum3 - target);
                        result = sum3;
                    }
                }
            }
        }
        return result;
    }

}