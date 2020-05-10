// .cs
// Author: hyan23
// <yyyy.mm.dd>
// <problem url>

// <Analysis>

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
        }
    }
}
