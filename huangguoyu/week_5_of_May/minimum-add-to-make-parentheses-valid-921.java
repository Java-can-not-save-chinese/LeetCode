package com.itheima;

import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') stack.pop();
            else stack.push(c);
        }
        return stack.size();
    }
}