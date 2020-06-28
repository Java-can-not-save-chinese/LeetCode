package week13;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_offer_057 {

    public static int[] twoSum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int sum =0;
        int []result = new  int[2];
        //双指针 + 二分
        while (left < right){
            sum = nums[right] + nums[left];
            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else{
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int nums[] = {16,16,18,24,30,32};
        twoSum(nums, 48);

    }
}
