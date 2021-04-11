package week1;

public class LeetCode5726 {

    public static void main(String[] args) {
        int []nums = {-1,1,-1,1,-1};

        System.out.println(arraySign(nums));
    }


    public static int arraySign(int[] nums) {
        int result = 0;

        int lessZeroNum = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                return result;
            }else{
                if(nums[i] < 0){
                    lessZeroNum++;
                }
            }
        }

        if(lessZeroNum % 2 == 0){
            result = 1;
        }else {
            result = -1;
        }

        return result;
    }

}
