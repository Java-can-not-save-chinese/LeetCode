class Solution {
public:
    int titleToNumber(string s) {
        int ret = 0;
        long long base = 1;
        
        for (auto it = s.rbegin(); it != s.rend(); ++it) {
            ret += base * (*it - 'A' + 1);
            base *= 26;
        }
        
        return ret;
    }
};