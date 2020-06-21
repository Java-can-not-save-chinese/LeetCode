package LeetCode.xinchengzhu.week8;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_255 {

    /**
     * 队列实现栈
     *
     * 栈 先入后出
     * 队列 先入先出
     */


    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    static class MyStack {
        List<Integer> q1 = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int r = q1.get(q1.size()-1);
            q1.remove(q1.size()-1);
            return r;
        }

        /** Get the top element. */
        public int top() {
            return q1.get(q1.size()-1);
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.size() == 0;
        }
    }
}
