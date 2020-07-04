package week14;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_offer_042 {
    public static void main(String[] args) {

    }

    /**
     * 连续子数组最大和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];

        /**
         * 遍历数组，
         * 当前数如果小于0 那么和肯定比之前的小，所以直接丢弃重新开始
         */
        for(int n : nums){
            if(sum > 0){
                sum += n;
            }else{
                sum = n;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
