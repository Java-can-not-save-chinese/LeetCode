import java.util.Arrays;

/**
 * @Description: 88合并两个有序数组
 * @Auther: zhurongsheng
 * @Date: 2020/4/5 10:21
 */
public class LeetCode_88 {

    public static void main(String[] args) {

        int num1[]=new int[]{1,2,3,0,0,0};
        int num2[]=new int[]{2,5,6};

        merge(num1,3,num2,3);

        System.out.println(num1);

    }

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
     *
     *  
     *
     * 说明:
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

}


