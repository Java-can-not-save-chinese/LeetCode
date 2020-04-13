// RotateList.cs
// Author: hyan23
// 2019.11.03
// https://leetcode.com/problems/rotate-list/

/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */

// Runtime: 96 ms, faster than 73.22% of C# online submissions for Rotate List.
// Memory Usage: 24.8 MB, less than 25.00% of C# online submissions for Rotate List.

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
            ListNode head = new int[] { 1, 2, 3, 4, 5 }.ToLinkedList();
            Console.WriteLine(string.Join(",", RotateRight(head, 2).ToArray()));
            head = new int[] { 1, 2, 3, 4, 5 }.ToLinkedList();
            Console.WriteLine(string.Join(",", RotateRight(head, 5).ToArray()));
            head = new int[] { 1, 2, 3, 4, 5 }.ToLinkedList();
            Console.WriteLine(string.Join(",", RotateRight(head, 7).ToArray()));
            head = new int[] { 1, 2, 3, 4, 5 }.ToLinkedList();
            Console.WriteLine(string.Join(",", RotateRight(head, 0).ToArray()));

            head = new int[] { 1 }.ToLinkedList();
            Console.WriteLine(string.Join(",", RotateRight(head, 1).ToArray()));
            head = new int[] { 1 }.ToLinkedList();
            Console.WriteLine(string.Join(",", RotateRight(head, 2).ToArray()));
        }

        public ListNode RotateRight(ListNode head, int k)
        {
            if (head == null)
            {
                return head;
            }

            int length = 0;
            ListNode cur = head;
            while (cur != null)
            {
                cur = cur.next;
                length++;
            }
            k %= length;

            ListNode @newHead = cur = head;
            int nodeNumber = 1;
            if (k > 0)
            {
                while (true)
                {
                    ListNode next = cur.next;
                    if (next == null)
                    {
                        cur.next = head;
                        break;
                    }
                    if (nodeNumber == length - k)
                    {
                        @newHead = next;
                        cur.next = null;
                    }
                    nodeNumber++;
                    cur = next;
                }
            }
            return @newHead;
        }
    }
}
