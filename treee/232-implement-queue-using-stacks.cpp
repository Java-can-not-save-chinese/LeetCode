class MyQueue {
public:
    /** Initialize your data structure here. */
    MyQueue() {

    }

    /** Push element x to the back of queue. */
    void push(int x) {
        if (this->empty()) {
            s1.push(x);
            return;
        }

        while (!s1.empty()) {
            s2.push(s1.top());
            s1.pop();
        }

        s1.push(x);
        while (!s2.empty()) {
            s1.push(s2.top());
            s2.pop();
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int ret;
        if (s1.empty()) {
            ret = s2.top();
            s2.pop();
            return ret;
        }

        ret = s1.top();
        s1.pop();
        return ret;
    }

    /** Get the front element. */
    int peek() {
        if (s1.empty())
            return s2.top();
        return s1.top();
    }

    /** Returns whether the queue is empty. */
    bool empty() {
        return s1.empty() && s2.empty();
    }

private:
    stack<int> s1, s2;
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */