// ReverseLinkedListII.cs
// Author: hyan23
// 2020.04.14
// https://leetcode.com/problems/reverse-linked-list-ii/

// Runtime: 92 ms, faster than 65.04% of C# online submissions for Reverse Linked List II.
// Memory Usage: 24.1 MB, less than 20.00% of C# online submissions for Reverse Linked List II.

using System;
using System.Collections.Generic;
using System.Diagnostics;

namespace csharp
{
    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public static class MyExtensions
    {
        public static ListNode ToLinkedList(this int[] arr)
        {
            Trace.Assert(arr.Length > 0);
            ListNode head = new ListNode(arr[0]);
            ListNode cur = head;
            for (int i = 1; i < arr.Length; i++)
            {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
            return head;
        }

        public static string StringJoin(this int[] arr)
        {
            return string.Join(", ", arr);
        }

        public static int[] ToArray(this ListNode head)
        {
            List<int> list = new List<int>();
            while (head != null)
            {
                list.Add(head.val);
                head = head.next;
            }
            return list.ToArray();
        }
    }

    public class Program
    {
        public static void Main()
        {
            new Program().Test();
        }

        public void Test()
        {
            Console.WriteLine(ReverseBetween(new int[] { 1 }.ToLinkedList(), 1, 1).ToArray().StringJoin());
            Console.WriteLine(ReverseBetween(new int[] { 1, 2 }.ToLinkedList(), 1, 2).ToArray().StringJoin());
            Console.WriteLine(ReverseBetween(new int[] { 1, 2, 3, 4, 5 }.ToLinkedList(), 1, 2).ToArray().StringJoin());
            Console.WriteLine(ReverseBetween(new int[] { 1, 2, 3, 4, 5 }.ToLinkedList(), 2, 4).ToArray().StringJoin());
            Console.WriteLine(ReverseBetween(new int[] { 1, 2, 3, 4, 5 }.ToLinkedList(), 2, 5).ToArray().StringJoin());
            Console.WriteLine(ReverseBetween(new int[] { 1, 2, 3, 4, 5 }.ToLinkedList(), 1, 5).ToArray().StringJoin());
            Console.WriteLine(ReverseBetween(new int[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 }.ToLinkedList(), 2, 8).ToArray().StringJoin());
        }

        public ListNode ReverseBetween(ListNode head, int m, int n)
        {
            ListNode skip = head;
            for (int i = 0; i < m - 2; i++)
            {
                skip = skip.next;
            }

            ListNode preprev = m > 1 ? skip : null;
            ListNode tail = m > 1 ? skip.next : skip;
            ListNode prev = tail;
            ListNode cur = prev.next;

            for (int i = 0; i < n - m; i++)
            {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }

            if (preprev != null)
            {
                tail.next = cur;
                preprev.next = prev;
                return head;
            }
            else
            {
                tail.next = cur;
                return prev;
            }
        }
    }
}
