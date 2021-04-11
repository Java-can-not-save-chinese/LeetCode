package week1;

public class LeetCode0976 {

    public static void main(String[] args) {
        int a[] = {1,2,2,4,18,8};
        System.out.println(largestPerimeter(a));
    }

    public static int largestPerimeter(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            for(int j = 0; j < nums.length - i -1; j++){
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }

            if(i>=2){
                //最大的三条边已经选出来了
                int a = nums[nums.length-1-count];
                int b = nums[nums.length-2-count];
                int c = nums[nums.length-3-count];
                if(b+c > a){
                    return a+b+c;
                }
                count++;
            }
        }
        return 0;
    }
}
