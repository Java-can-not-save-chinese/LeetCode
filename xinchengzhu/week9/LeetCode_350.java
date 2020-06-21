package LeetCode.xinchengzhu.week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class LeetCode_350 {


    public static void main(String[] args) {
        int []n1 = new int[]{4,9,5};
        int []n2 = new int[]{9,4,9,8,4};
        intersect(n1, n2);
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        /**
         * 使用一个map 记录 nums1中每个数字出现的次数。
         * 再遍历另一个数组，如果nums2中的数字有在nums1中出现，那么记录下来，同时将map中的出现次数减一。
         * map用来做记录
         */
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : nums1){
            map.put(a,map.getOrDefault(a,0) +1);
        }

        int index = 0;

        for(int n: nums2){
            int cur = map.getOrDefault(n, 0);
            if(cur > 0){
                nums1[index] = n;
                index++;
                map.put(n, cur-1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, index);


    }
}
