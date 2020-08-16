package week18;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0922 {
    public int[] sortArrayByParityII(int[] A) {
        int oIndex=0,eIndex=0;
        int odd[] = new int[A.length/2];
        int even[] = new int[A.length/2];

        for(int i : A){
            if(i % 2 == 0){
                even[eIndex++] = i;
            }else{
                odd[oIndex++] = i;
            }
        }
        oIndex=0;
        eIndex=0;

        for(int i=0;i<A.length;i++){
            if(i%2==0){
                A[i]=even[eIndex++];
            }else{
                A[i]=odd[oIndex++];
            }
        }
        return A;

    }
}
