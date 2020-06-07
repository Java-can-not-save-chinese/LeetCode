class Solution {
public:
    bool isValid(string s) {
        if (s == "")
            return true;
        
        stack<char> stk;
        
        for (auto c : s) {
            if (c == '(' || c == '[' || c == '{')
                stk.push(c);
            if (c == ')')
                if (!stk.empty() && stk.top() == '(')
                    stk.pop();
                else
                    return false;
            if (c == ']')
                if (!stk.empty() && stk.top() == '[')
                    stk.pop();
                else
                    return false;
            if (c == '}')
                if (!stk.empty() && stk.top() == '{')
                    stk.pop();
                else
                    return false;
        }
        
        return stk.empty();
    }
};