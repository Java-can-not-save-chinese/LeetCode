package week14;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *
 * x =0
 * y =0
 *
 * 交替循环
 * x 先自增 到最大时
 * y 自增 到最大时
 * x 做减法 减到可以减的最小值
 * y 做减法 减到可以减的最小值
 * x 又自增
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 1 2  3  4
 * 5 6  7  8
 * 9 10 11 12
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class LeetCode_offer_029 {
    public static void main(String[] args) {
        int a[][] = new int[3][3];
        int k =1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                a[i][j] = k;
                k++;
            }
        }
        spiralOrder(a);
    }

    public static int[] spiralOrder(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[] result = new int[rowLength*colLength];
        int x=0,y=0;
        int i = 0;
        //boolean opt = true;

        int endX = rowLength == 1 ? 0 : 1;
        int endY = colLength-2;

        while (x != endX || y!= endY){
            result[i] = matrix[x][y];
            i++;

            if( y != rowLength - 1  && x != colLength - 1){
                y++;
            }else if(y == rowLength -1 && x != colLength - 1){
                x++;
            }else if(y == 0 ){
                x--;
            }else if(x == colLength - 1 ){
                y--;
            }

        }



        return result;
    }
}
