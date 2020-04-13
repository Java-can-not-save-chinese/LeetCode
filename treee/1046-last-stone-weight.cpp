class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> que;
        for_each(stones.begin(), stones.end(), [&que](int t) {
            que.push(t);
        });
        
        while (!que.empty()) {
            int t1 = que.top();
            que.pop();
            if (que.empty())
                return t1;
            int t2 = que.top();
            que.pop();
            if (t1 != t2)
                que.push(t1 - t2);
        }
        
        return 0;
    }
};