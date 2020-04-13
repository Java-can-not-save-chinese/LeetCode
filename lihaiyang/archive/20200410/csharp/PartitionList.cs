// PartitionList.cs
// Author: hyan23
// 2020.02.01
// https://leetcode.com/problems/partition-list/

/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
*/

// Runtime: 96 ms, faster than 62.16% of C# online submissions for Partition List.
// Memory Usage: 24.8 MB, less than 100.00% of C# online submissions for Partition List.

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
            Console.WriteLine(string.Join(",", Partition(new int[] { 1, 4, 3, 2, 5, 2 }.ToLinkedList(), 3).ToArray()));
            Console.WriteLine(string.Join(",", Partition(null, 3).ToArray()));
            Console.WriteLine(string.Join(",", Partition(new int[] { 1, 4, 3, 2, 5, 2 }.ToLinkedList(), 0).ToArray()));
            Console.WriteLine(string.Join(",", Partition(new int[] { 1, 4, 3, 2, 5, 2 }.ToLinkedList(), 5).ToArray()));
            Console.WriteLine(string.Join(",", Partition(new int[] { 1, 4, 3, 2, 5, 2 }.ToLinkedList(), 6).ToArray()));
        }

        public ListNode Partition(ListNode head, int x)
        {
            ListNode ph = head;
            ListNode first = null, pf = null;
            ListNode second = null, ps = null;

            while (ph != null)
            {
                ListNode next = ph.next;
                ph.next = null;

                if (ph.val < x)
                {
                    if (first == null)
                    {
                        pf = first = ph;
                    }
                    else
                    {
                        pf.next = ph;
                        pf = pf.next;
                    }
                }
                else
                {
                    if (second == null)
                    {
                        ps = second = ph;
                    }
                    else
                    {
                        ps.next = ph;
                        ps = ps.next;
                    }
                }
                ph = next;
            }

            if (pf != null)
            {
                pf.next = second;
                return first;
            }
            else
            {
                return second;
            }
        }
    }
}
