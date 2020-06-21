package week05;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/3 17:07
 */
public class LeetCode_894 {

    public boolean isMonotonic(int[] A) {
        return increasing(A) || decreasing(A);
    }

    public boolean increasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1]) {
                return false;
            }
        }
        return true;
    }

    public boolean decreasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] < A[i+1]) {
                return false;
            }
        }
        return true;
    }


}
