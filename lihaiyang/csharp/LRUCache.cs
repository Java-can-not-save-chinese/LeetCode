// LRUCache.cs
// Author: hyan23
// 2020.04.25
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3309/

// Runtime: 252 ms
// Memory Usage: 50.2 MB

using System.Collections.Generic;

namespace csharp
{
    public class LRUCache
    {
        public LRUCache(int capacity)
        {
            _capacity = capacity;
            _keyToValue = new Dictionary<int, int>();
            _keyToQNode = new Dictionary<int, LinkedListNode<int>>();
            _queue = new LinkedList<int>();
        }

        public int Get(int key)
        {
            if (_keyToValue.ContainsKey(key))
            {
                _RefreshNode(key);
                return _keyToValue[key];
            }
            else
            {
                return -1;
            }
        }

        public void Put(int key, int value)
        {
            if (_keyToValue.ContainsKey(key))
            {
                _RefreshNode(key);
                _keyToValue[key] = value;
            }
            else
            {
                if (_keyToValue.Count >= _capacity)
                {
                    _RemoveLRU();
                }
                _keyToValue[key] = value;
                _queue.AddLast(key);
                _keyToQNode.Add(key, _queue.Last);
            }
        }

        private void _RefreshNode(int key)
        {
            if (_keyToQNode.ContainsKey(key))
            {
                LinkedListNode<int> qnode = _keyToQNode[key];
                _queue.Remove(qnode);
                _queue.AddLast(qnode);
            }
        }

        private void _RemoveLRU()
        {
            if (_queue.Count > 0)
            {
                int key = _queue.First.Value;
                _keyToValue.Remove(key);
                _keyToQNode.Remove(key);
                _queue.RemoveFirst();
            }
        }

        private int _capacity;
        private Dictionary<int, int> _keyToValue;
        private Dictionary<int, LinkedListNode<int>> _keyToQNode;
        private LinkedList<int> _queue;
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.Get(key);
     * obj.Put(key,value);
     */

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
