package week08;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/20 20:47
 */
public class LeetCode_75 {


    /**
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     */
    public static void main(String[] args) {

        int[] nums = {2, 0, 1};
        sortColors(nums);

        System.out.println("############");
    }


    /**
     * 双指针把0移动到左边，把2移动到右边
     */
    public static void sortColors(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int index = 0;
        while (index <= rightIndex) {
            if (nums[index] == 0) {
                swap(nums, leftIndex++, index++);
            } else if (nums[index] == 2) {
                swap(nums, index, rightIndex--);
            } else {
                index++;
            }
        }
    }


    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
