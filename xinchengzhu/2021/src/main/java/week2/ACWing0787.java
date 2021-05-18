package week2;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 给定一个长度为 n 的整数数列，以及一个整数 k，请用快速选择算法求出数列从小到大排序后的第 k 个数。

 输入格式
 第一行包含两个整数 n 和 k。

 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整数数列。

 输出格式
 输出一个整数，表示数列的第 k 小数。

 数据范围
 1≤n≤100000,
 1≤k≤n
 输入样例：
 5 3
 2 4 1 5 3
 输出样例：
 3
 */
public class ACWing0786 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        //输入
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        //处理
        //输出
        System.out.print(quickSort(arr, 0, n-1, k));


    }

    private static int quickSort(int[] arr, int l, int r, int k) {
        if(l == r) return arr[l];
        //i 左边指针
        //j 右边指针
        //x 快排的标杆数
        int i=l-1, j=r+1, x = arr[l];
        /**
         * 快排思想
         * 左边小于标杆数
         * 右边大于标杆数
         */
        while (i<j){

            while (arr[++i] < x){

            }
            while (arr[--j] > x){

            }

            if(i<j) {
                //交换数字
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int sl = j - l +1;
        if(k <= sl){
            return quickSort(arr, l, j, k);
        }
        return quickSort(arr, j+1, r, k -sl);
    }
}
