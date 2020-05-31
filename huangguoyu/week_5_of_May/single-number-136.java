package com.itheima;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for(int i : nums) {
            if (sets.contains(i)) sets.remove(i);
            else sets.add(i);
        }
        int res = 0;
        for(int i : sets) res = i;
        return res;
    }
}