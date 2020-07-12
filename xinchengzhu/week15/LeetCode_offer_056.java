package week15;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_offer_056 {

    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for(int i=0; i< nums.length; i++){
            res ^= nums[i];
        }
        //找出异或结果中 为1 的位
        //就能确定分组的位置
        int div = 1;
        while ((div & res) == 0)
            div <<= 1;

        int a = 0, b = 0;
        for (int n : nums)
            if ((div & n ) == 0)
                a ^= n;
            else
                b ^= n;
        return new int[]{a,b};
    }

}
