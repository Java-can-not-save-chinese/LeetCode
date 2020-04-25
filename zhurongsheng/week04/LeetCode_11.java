package week04;



/**
 * @Description:
 * @Auther: zhurongsheng
 * @Date: 2020/4/17 23:06
 */
public class LeetCode_11 {


    public static int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = -1;

        while (left != right) {
            //临时面积
            int demArea = (right - left) * Math.min(height[left], height[right]);
            if (demArea > maxArea) {
                maxArea = demArea;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
