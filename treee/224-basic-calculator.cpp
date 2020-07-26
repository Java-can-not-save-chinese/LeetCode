class Solution {
public:
    
    pair<int, char> next(string&s, int *idx, int *f) {
        while (*idx < s.length() && s[*idx] == ' ')
            ++(*idx);
        if (*idx == s.length()) {
            *f = 1;
            return make_pair(0, ' ');
        }
        if (isdigit(s[*idx])) {
            string t = "";
            while (isdigit(s[*idx]))
                t += s[(*idx)++];
            return make_pair(atoi(t.c_str()), ' ');
        }
        return make_pair(0, s[(*idx)++]);
    }
    
    int calc(int a, int b, char op) {
        if (op == '+')
            return b + a;
        return b - a;
    }
    
    int calculate(string s) {
        int i = 0;
        stack<int> stkNum;
        stack<char> stkOp;
        int f = 0;
        while (i < s.length()) {
            auto t = next(s, &i, &f);
            if (f)
                break;
            if (t.second != ' ') {
                if (t.second == ')') {
                    stkOp.pop();
                    if (!stkOp.empty()) {
                        int r = stkNum.top();
                        stkNum.pop();
                        r = calc(r, stkNum.top(), stkOp.top());
                        stkOp.pop();
                        stkNum.pop();
                        stkNum.push(r);
                    }
                }
                else {
                    stkOp.push(t.second);
                }
            }
            else {
                if (stkOp.empty() || stkOp.top() == '(')
                    stkNum.push(t.first);
                else {
                    int r = calc(t.first, stkNum.top(), stkOp.top());
                    stkNum.pop();
                    stkNum.push(r);
                    stkOp.pop();
                }
            }
        }
        
        return stkNum.top();
    }
};
