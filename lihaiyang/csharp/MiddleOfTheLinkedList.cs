// MiddleOfTheLinkedList.cs
// Author: hyan23
// 2020.04.11
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3290/

// Runtime: 96 ms
// Memory Usage: 23.8 MB

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
            Console.WriteLine(MiddleNode(new int[] { 1, 2, 3, 4, 5 }.ToLinkedList()).val);
            Console.WriteLine(MiddleNode(new int[] { 1, 2, 3, 4, 5, 6 }.ToLinkedList()).val);
        }

        public ListNode MiddleNode(ListNode head)
        {
            ListNode cur = head.next, middle = head;
            int count = 2;
            while (cur != null)
            {
                if (count % 2 == 0)
                {
                    middle = middle.next;
                }
                cur = cur.next;
                count++;
            }
            return middle;
        }
    }
}
