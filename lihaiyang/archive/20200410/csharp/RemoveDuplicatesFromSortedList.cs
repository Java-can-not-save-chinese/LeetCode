// RemoveDuplicatesFromSortedList.cs
// Author: hyan23
// 2019.11.22
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

/* 
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
*/

// Runtime: 96 ms, faster than 78.70% of C# online submissions for Remove Duplicates from Sorted List.
// Memory Usage: 25.3 MB, less than 16.67% of C# online submissions for Remove Duplicates from Sorted List.

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
        }

        public ListNode DeleteDuplicates(ListNode head)
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
