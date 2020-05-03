// FirstUniqueNumber.cs
// Author: hyan23
// 2020.04.29
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/

// Runtime: 728 ms
// Memory Usage: 75.9 MB

using System.Collections.Generic;

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

        public class FirstUnique
        {
            public FirstUnique(int[] nums)
            {
                _dict = new Dictionary<int, LinkedListNode<int>>();
                _uniq = new LinkedList<int>();

                foreach (var val in nums)
                {
                    Add(val);
                }
            }

            public int ShowFirstUnique()
            {
                return _uniq.Count > 0 ? _uniq.First.Value : -1;
            }

            public void Add(int value)
            {
                if (!_dict.ContainsKey(value))
                {
                    _uniq.AddLast(value);
                    _dict.Add(value, _uniq.Last);
                }
                else
                {
                    if (_dict[value] != null)
                    {
                        _uniq.Remove(_dict[value]);
                        _dict[value] = null;
                    }
                }
            }

            private readonly Dictionary<int, LinkedListNode<int>> _dict;
            private readonly LinkedList<int> _uniq;
        }

        /**
         * Your FirstUnique object will be instantiated and called as such:
         * FirstUnique obj = new FirstUnique(nums);
         * int param_1 = obj.ShowFirstUnique();
         * obj.Add(value);
         */
    }
}
