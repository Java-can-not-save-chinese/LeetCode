package week09;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/27 19:09
 */
public class LeetCode_48 {

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = temp;
            }
        }
    }

}
