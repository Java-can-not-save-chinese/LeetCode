package week2;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 快速排序模板
 * 给定你一个长度为 n 的整数数列。
 *
 * 请你使用快速排序对这个数列按照从小到大进行排序。
 *
 * 并将排好序的数列按顺序输出。
 *
 * 输入格式
 * 输入共两行，第一行包含整数 n。
 *
 * 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整个数列。
 *
 * 输出格式
 * 输出共一行，包含 n 个整数，表示排好序的数列。
 *
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 5
 * 3 1 2 4 5
 * 输出样例：
 * 1 2 3 4 5
 */
public class ACWing0785 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        //输入
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        //处理
        quickSort(arr, 0, n-1);
        //输出
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSort(int[] arr, int l, int r) {
        if(l >= r) return;
        //i 左边指针
        //j 右边指针
        //x 快排的标杆数
        int i=l-1, j=r+1, x = arr[l+r >> 1];
        /**
         * 快排思想
         * 左边小于标杆数
         * 右边大于标杆数
         */
        while (i<j){
            //左边一直向右走直到arr[i] >= x
            do {
                i++;
            }while (arr[i] < x);
            //右边一直向左走 直到arr[i] <= x
            do {
                j--;
            }while (arr[j] > x);

            if(i<j) {
                //交换数字
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        quickSort(arr, l, j);
        quickSort(arr, j+1, r);
    }
}
