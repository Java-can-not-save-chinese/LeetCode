package week05;


import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Auther: zhurongsheng
 * @Date: 2020/4/17 23:06
 */
public class LeetCode_888 {


    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;
        for (int x: A) {
            sa += x;
        }
        for (int x: B) {
            sb += x;
        }
        int delta = (sb - sa) / 2;
        Set<Integer> setB = new HashSet();
        for (int x: B) {
            setB.add(x);
        }

        for (int x: A) {
            if (setB.contains(x + delta)) {
                return new int[]{x, x + delta};
            }
        }
        throw null;
    }


}
