package week13;

import java.util.ArrayList;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 */
public class LeetCode_offer_057_I {

    public static void main(String[] args) {
        int [][] result = findContinuousSequence1(9);
        System.out.println(result);
    }

    public static int[][] findContinuousSequence(int target) {
        int flag = -1;
        boolean isFirst = false;
        int sum = 0;
        ArrayList<int[]> lists = new ArrayList<>();
        for(int i=1; i<target; i++){
            if(!isFirst){
                flag = i;
                isFirst = true;
            }
            sum += i;
            if(sum == target){
                int[] li = new int[i-flag+1];
                int index = 0;
                for(int j=flag; j<=i; j++){
                    li[index++] = j;
                }
                lists.add(li);

                isFirst = false;
                i = flag;
                sum = 0;
            }else if(sum > target){
                isFirst = false;
                i = flag;
                sum = 0;
            }
        }
        return (int[][])lists.toArray(new int[lists.size()][]);
    }

    public static int[][] findContinuousSequence1(int target) {
        ArrayList<int[]> lists = new ArrayList<>();
        int left = 1;
        int right = 1;
        int sum = 0;

        while (left <= target/2){
            if(sum < target){
                sum+=right;
                right++;
            }else if (sum > target){
                sum -= left;
                left++;
            }else {
                int[] li = new int[right-left];
                int index = 0;
                for(int j=left; j<right; j++){
                    li[index++] = j;
                }
                lists.add(li);
                sum -= left;
                left++;
            }
        }
        return (int[][])lists.toArray(new int[lists.size()][]);
    }
}
