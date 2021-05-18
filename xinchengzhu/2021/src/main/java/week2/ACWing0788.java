package week2;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 给定你一个长度为 n 的整数数列。

 请你使用归并排序对这个数列按照从小到大进行排序。

 并将排好序的数列按顺序输出。

 输入格式
 输入共两行，第一行包含整数 n。

 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整个数列。

 输出格式
 输出共一行，包含 n 个整数，表示排好序的数列。

 数据范围
 1≤n≤100000
 输入样例：
 5
 3 1 2 4 5
 输出样例：
 1 2 3 4 5
 */
public class ACWing0787 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        //输入
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        //处理
        mergeSort(arr, 0, n-1);
        //输出
        for(int i=0; i<arr.length; i++){

            System.out.print(arr[i] + " ");
        }


    }

    private static void mergeSort(int[] arr, int l, int r) {
        if(l >= r) return ;

        int mid = l+r >> 1;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        int tmp[] = new int[r-l+1];
        int k=0, i=l, j=mid+1;
        while (i<=mid && j <= r){
            if(arr[i] <= arr[j]){
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }

        while (i <= mid){
            tmp[k++] = arr[i++];
        }
        while (j <= r){
            tmp[k++] = arr[j++];
        }

        for(i=l,j=0; i<=r; i++,j++){
            arr[i]=tmp[j];
        }
    }
}
