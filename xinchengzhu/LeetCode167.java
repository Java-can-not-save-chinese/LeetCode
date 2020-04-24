package LeetCode.xinchengzhu;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode167 {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int end = numbers.length - 1;

        int res[] = new int[2];

        while(first < end){
            if((numbers[first] + numbers[end]) == target){
                res[0] = first+1;
                res[1] = end+1;
                return res;
            }else if((numbers[first] + numbers[end]) > target){
                //大于target
                end--;
            }else{
                //小于target
                first++;
            }

        }

        return res;
    }
}
