// DiagonalTraverseII.cs
// Author: hyan23
// 2020.04.28
// https://leetcode.com/contest/weekly-contest-186/problems/diagonal-traverse-ii/

// Runtime: 540 ms, faster than 90.43% of C# online submissions for Diagonal Traverse II.
// Memory Usage: 57.1 MB, less than 100.00% of C# online submissions for Diagonal Traverse II.

using System.Collections.Generic;
using System.Linq;

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
        }

        class MyList
        {
            public MyList(IList<int> l, int idx)
            {
                L = l;
                Idx = idx;
            }

            public bool Full => Idx >= L.Count;

            public IList<int> L { get; set; }
            public int Idx { get; set; }
        }

        public int[] FindDiagonalOrder(IList<IList<int>> nums)
        {
            if (nums.Count == 0)
            {
                return new int[0];
            }

            List<int> results = new List<int>();
            LinkedList<MyList> numLists = new LinkedList<MyList>();

            for (int i = 0; i < nums.Count; i++)
            {
                if (nums[i].Count > 0)
                {
                    results.Add(nums[i][0]);
                }

                foreach (var list in numLists)
                {
                    results.Add(list.L[list.Idx]);
                    list.Idx++;
                }

                numLists.AddFirst(new MyList(nums[i], 1));

                numLists.Where(x => x.Full).ToList().ForEach(x => numLists.Remove(x));
            }

            while (numLists.Count > 0)
            {
                foreach (var item in numLists)
                {
                    results.Add(item.L[item.Idx]);
                    item.Idx++;
                }

                numLists.Where(x => x.Full).ToList().ForEach(x => numLists.Remove(x));
            }

            return results.ToArray();
        }
    }
}
