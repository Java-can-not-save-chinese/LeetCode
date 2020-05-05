// MinStack.cs
// Author: hyan23
// 2020.04.12
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3292/

// Runtime: 172 ms
// Memory Usage: 51.4 MB

using System;

namespace csharp
{
    public class Program
    {
        public static void Main()
        {
            new Program().Test();
        }

        public void Test()
        {
            MinStack minStack = new MinStack();
            minStack.Push(-2);
            minStack.Push(0);
            minStack.Push(-3);
            Console.WriteLine(minStack.GetMin()); // Returns - 3.
            minStack.Pop();
            Console.WriteLine(minStack.Top()); // Returns 0.
            Console.WriteLine(minStack.GetMin()); // Returns - 2.
        }
    }

    public class MinStack
    {
        /** initialize your data structure here. */
        public MinStack()
        {
            _arr = new StackElement[INITIAL_SIZE];
            _top = -1;
        }

        public void Push(int x)
        {
            if (_top == _arr.Length - 1)
            {
                StackElement[] tmp = new StackElement[_arr.Length + STACK_INC];
                _arr.CopyTo(tmp, 0);
                _arr = tmp;
            }

            int min = Empty ? x : Math.Min(GetMin(), x);
            _arr[++_top] = new StackElement() { Val = x, Min = min };
        }

        public void Pop()
        {
            _CheckEmpty();
            _top--;
        }

        public int Top()
        {
            _CheckEmpty();
            return _arr[_top].Val;
        }

        public int GetMin()
        {
            _CheckEmpty();
            return _arr[_top].Min;
        }

        private void _CheckEmpty()
        {
            if (Empty)
            {
                throw new InvalidOperationException("Stack is empty");
            }
        }

        private class StackElement
        {
            public int Val { get; set; }
            public int Min { get; set; }
        }

        public bool Empty => _top < 0;

        private StackElement[] _arr;
        private int _top;
        private const int INITIAL_SIZE = 10;
        private const int STACK_INC = 5;
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.Push(x);
     * obj.Pop();
     * int param_3 = obj.Top();
     * int param_4 = obj.GetMin();
     */
}
