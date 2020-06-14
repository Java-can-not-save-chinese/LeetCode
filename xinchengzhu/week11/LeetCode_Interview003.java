package LeetCode.xinchengzhu.week11;

import java.util.HashMap;

/***
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 *
 */
public class LeetCode_Interview003 {

    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        int index[] = new int[nums.length];
        int result = -1;
        for(int i=0 ;i<nums.length; i++){
            if(index[nums[i]] == 1){
                result = nums[i];
                break;
            }else{
                index[nums[i]] = 1;
            }
        }

        return result;
    }

}
