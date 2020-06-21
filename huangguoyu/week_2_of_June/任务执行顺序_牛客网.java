package com.alg;

import com.gy.activeobjects.client.Test;

import java.util.HashMap;
import java.util.Scanner;
/**
    给定[1,9]的一个以逗号分隔的字符串的任务序列
    返回这些任务的真正执行顺序如：
    1,3,9,2

    4 2 1 0
*/
public class Main {
    public static void main(String[] args) {
        int[] num = new int[10];
        int[] used = new int[10];

        Scanner sc = new Scanner(System.in);
        String task = sc.nextLine();

        Integer item;
        String[] tasks = task.split(",");
        for (String s : tasks) {
            item = Integer.valueOf(s);
            if(item <= 0) return;
            num[item]++;
        }

        StringBuilder res = new StringBuilder();

        for (String s : tasks) {
            item = Integer.valueOf(s);
            int preNum = 0;
            for(int i = (item + 1); i < 10; i++) {
                preNum += num[i];
            }
            preNum += used[item];
            res.append(preNum + ",");
            used[item]++;
        }
        String resStr = res.toString();
        System.out.println(resStr.substring(0, resStr.length()-1));
    }

}
