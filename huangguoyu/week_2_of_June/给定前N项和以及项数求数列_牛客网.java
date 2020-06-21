package com.alg;

import com.gy.activeobjects.client.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sn, n, a1;
        Scanner sc = new Scanner(System.in);
        sn = sc.nextInt();
        n = sc.nextInt();

        int up = (2*sn - n*n + n);
        int low = 2*n;
        //无解情况
        if (up % low != 0) {
            System.out.println(-1);
            return;
        }

        a1 = up / low;

        if (a1 <= 0) {
            System.out.println(-1);
            return;
        }

        int printItem = a1 - 1;
        for (int i = 0; i < n; i++) {
            printItem++;
            System.out.print(printItem);
            System.out.print(" ");
        }
    }
}
