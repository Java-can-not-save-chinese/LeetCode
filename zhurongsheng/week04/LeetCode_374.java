package week04;

/**
 * @Description:
 * @Auther: zhurongsheng
 * @Date: 2020/4/26 00:16
 */
public class LeetCode_374 {

    public int guessNumber(int n) {
        int lower = 1;
        int higher = n;
        while (lower <= higher) {
            int mid = lower + (higher - lower) / 2;
            int temp = guess(mid);
            if (temp == 0) return mid;
            else if (temp == 1) lower = mid+1;
            else higher = mid - 1;
        }
        return -1;
    }

    private int guess(int num) {
        return Integer.compare(num, 1);
    }

}
