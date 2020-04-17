package LeetCode.xinchengzhu;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_283 {

    public static void main(String[] args) {
        int[] a = new int[]{0,1,0,3,12};

        moveZeroes(a);
    }

    public static int[] moveZeroes(int[] nums) {
        int notZeroIndex = 0;

        for(int i=0; i<nums.length; i++){
            //只需要把不等于0的数向前移动，后面的肯定就是为0的
            if(nums[i] != 0){
                nums[notZeroIndex++] = nums[i];
            }
        }

        for(int i= notZeroIndex; i<nums.length; i++){
            nums[i] = 0;
        }

        return nums;
    }

}
