package LeetCode.xinchengzhu.week4;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * 通过次数41,973提交次数65,749
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_232 {


    static class  MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int res = -1;
            if(!stack1.isEmpty()){
                res = getNumber();
                stack1.remove(0);
            }
            return res;
        }

        /** Get the front element. */
        public int peek() {
            int res = -1;
            if(!stack1.isEmpty()){
                res = getNumber();
            }
            return res;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty();
        }

        private int getNumber(){
            int res = -1;
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            res = stack2.peek();
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return res;
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.peek());  // 返回 2
        System.out.println(queue.empty()); // 返回 false

    }
}
