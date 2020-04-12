class MinStack {
public:
    stack<pair<int, int>> stk;
    int cur_min;
    /** initialize your data structure here. */
    MinStack() {
        
    }
    
    void push(int x) {
        if (stk.empty())
            cur_min = x;
        else
            cur_min = min(cur_min, x);
        stk.push(make_pair(x, cur_min));
    }
    
    void pop() {
        stk.pop();
        if (!stk.empty())
            cur_min = stk.top().second;
    }
    
    int top() {
        return stk.top().first;
    }
    
    int getMin() {
        return cur_min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */