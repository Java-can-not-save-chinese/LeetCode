// RemoveDuplicatesFromSortedListII.cs
// Author: hyan23
// 2019.11.22
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

/* 
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
*/

// Runtime: 100 ms, faster than 52.74% of C# online submissions for Remove Duplicates from Sorted List II.
// Memory Usage: 25.2 MB, less than 33.33% of C# online submissions for Remove Duplicates from Sorted List II.

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
            Console.WriteLine(string.Join(", ", DeleteDuplicates(new int[] { 1, 2, 3, 3, 4, 4, 5 }.ToLinkedList()).ToArray()));
            Console.WriteLine(string.Join(", ", DeleteDuplicates(new int[] { 1, 1, 1, 2, 3 }.ToLinkedList()).ToArray()));
            Console.WriteLine(string.Join(", ", DeleteDuplicates(new int[] { 1, 1, 1 }.ToLinkedList()).ToArray()));
            Console.WriteLine(string.Join(", ", DeleteDuplicates(null).ToArray()));
        }

        public ListNode DeleteDuplicates(ListNode head)
        {
            ListNode front = null, rear = null;
            ListNode cur = head, prev = null;
            int counter = 0;

            while (cur != null)
            {
                if (prev != null && cur.val != prev.val)
                {
                    switch (counter)
                    {
                        case 1:
                            switch (rear)
                            {
                                case null:
                                    front = rear = prev;
                                    break;
                                default:
                                    rear.next = prev;
                                    rear = prev;
                                    break;
                            }
                            break;
                    }
                    counter = 1;
                }
                else
                {
                    counter++;
                }

                prev = cur;
                cur = cur.next;
                prev.next = null;
            }

            if (counter == 1)
            {
                if (rear == null)
                {
                    front = prev;
                }
                else
                {
                    rear.next = prev;
                }
            }

            return front;
        }

        // 看错题目
        public void Test2()
        {
            Console.WriteLine(string.Join(", ", DeleteDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }.ToLinkedList()).ToArray()));
            Console.WriteLine(string.Join(", ", DeleteDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }.ToLinkedList()).ToArray()));

            Console.WriteLine(string.Join(", ", DeleteDuplicates(new int[] { 1, 2, 3 }.ToLinkedList()).ToArray()));
            Console.WriteLine(string.Join(", ", DeleteDuplicates(new int[] { 1, 1, 2, 2, 3, 3 }.ToLinkedList()).ToArray()));
            Console.WriteLine(string.Join(", ", DeleteDuplicates(new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3 }.ToLinkedList()).ToArray()));
            Console.WriteLine(string.Join(", ", DeleteDuplicates(null).ToArray()));

            Console.WriteLine(string.Join(", ", DeleteDuplicates(new int[] { 1, 2, 3, 3, 4, 4, 5 }.ToLinkedList()).ToArray()));
            Console.WriteLine(string.Join(", ", DeleteDuplicates(new int[] { 1, 1, 1, 2, 3 }.ToLinkedList()).ToArray()));
            Console.WriteLine(string.Join(", ", DeleteDuplicates(new int[] { 1, 1, 1 }.ToLinkedList()).ToArray()));
        }

        public ListNode DeleteDuplicates2(ListNode head)
        {
            ListNode cur = head;
            ListNode tail = head;

            while (cur != null)
            {
                ListNode next = cur.next;
                cur.next = null;

                if (cur.val != tail.val)
                {
                    tail.next = cur;
                    tail = cur;
                }

                cur = next;
            }

            return head;
        }
    }
}
