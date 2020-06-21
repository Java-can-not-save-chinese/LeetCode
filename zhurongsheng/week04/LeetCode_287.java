package week04;


/**
 * @Description:
 * @Auther: zhurongsheng
 * @Date: 2020/4/17 23:06
 */
public class LeetCode_287 {


    /**
     * 二分查找
     * <p>
     * 1 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n）。
     * 2 算出这个数组的最低值(low)、最高值(row)、中间值(mid=low+(high-low)/2)。
     * 3 遍历整个数组，计算出<=中间值的数目,counts;如果counts>mid，那么说明重复的值在mid的左边，即high=mid
     * 如果counts=mid出现的值就在mid值的右边，即low=mid+1。
     * 4 重复步骤3，直到low=hight
     * 5 时间复杂度 nLogN
     * 5 例：
     * 1 1 2 3 4 5，low=1,high=5,mid=3,counts=4,说明重复的值在[1,3]。
     * 1 2 3 4 4 5,low=1,high=5,mid=3,counts=3,说明重复的值在[4,5]。
     */
    public int findDuplicate(int[] nums) {

        return dichotomia(1, nums.length - 1, nums);
    }

    private int dichotomia(int low, int high, int[] nums) {

        if (low == high) return low;
        int mid = low + (high - low) / 2;
        int counts = 0;
        for (int num : nums) {
            if (mid >= num) counts++;
        }
        if (counts > mid) {
            //重复数字在中间值左边
            return dichotomia(low, mid, nums);
        } else  {
            //重复数字在中间值右边
            return dichotomia(mid + 1, high, nums);
        }
    }


}
