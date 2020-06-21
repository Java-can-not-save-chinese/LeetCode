package com.itheima;

import java.util.*;

public class Main1 {

    public static long res = 0;
    public static Integer D = 0;
    public static int[] building;
    public static void main(String[] args) {
        System.out.println(C2(1000000, 2));
        Scanner scaner = new Scanner(System.in);
        int n = scaner.nextInt();
        D = scaner.nextInt();
        building = new int[n];

        if (n < 3) System.out.println(0);

        for (int i = 0; i < n; i++) {
            building[i] = scaner.nextInt();
        }
        // 排序 nlongn
//        Arrays.sort(building);
        for(int i = 0; i < building.length; i++) {
            int p = building.length - 1;
            while((building[p] - building[i]) > D) p--;
            int els = p - i;
            if (els >= 2) {
                res += C2(els, 2);
            }
        }

        System.out.println(res);
    }



    // 求排列数 A(n,m) n>m
    public static long A(int n, int m)
    {
        long result = 1;
        // 循环m次,如A(6,2)需要循环2次，6*5
        for (int i = m; i > 0; i--)
        {
            result *= n;
            n--;// 下一次减一
        }
        return result;
    }
    // 求组合数，这个也不需要了。定义式，不使用互补率
    public static long C2(int n, int m)
    {
        // int denominator=factorial(up);//分母up的阶乘
        // 分母
        long denominator = A(m, m);// A(6,6)就是求6*5*4*3*2*1,也就是求6的阶乘
        // 分子
        long numerator = A(n, m);// 分子的排列数
        return numerator / denominator;
    }

}