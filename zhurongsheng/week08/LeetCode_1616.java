package week08;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/21 21:01
 */
public class LeetCode_1616 {


    public static void main(String[] args) {


    }


    /**
     * 1 从左向右是一个递增序列，维护一个最大值，以及右索引，如果当前值大于最大值，
     * 更新最大值，否则更新右索引。
     * <p>
     * 2 从右向左维护一个递减序列，维护一个最小值，以及左索引，如果当前值小于最小值，
     * 更新最小值，以及左索引。
     * <p>
     * 3 返回左索引、右索引。
     */
    public static int[] subSort(int[] array) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int leftIndex = -1;
        int rightIndex = -1;

        for (int i = 0; i < array.length; i++) {
            //左->右
            if (array[i] >= max) {
                max = array[i];
            } else {
                rightIndex = i;
            }
            //右->左
            int temp = array.length - i - 1;
            if (array[temp] <= min) {
                min = array[temp];
            } else {
                leftIndex = temp;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }

}
