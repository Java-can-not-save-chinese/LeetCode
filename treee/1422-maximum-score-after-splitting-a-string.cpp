class Solution {
public:
    int maxScore(string s) {
        int r = count_if(s.begin() + 1, s.end(), [](char c) {
            return c == '1';
        });
        int ret = r;
        int l = 0;
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s[i] == '0') {
                l++;
                ret = max(ret, l + r);
            }
            else {
                if (i != 0)
                    r--;
            }
        }
        return ret;
    }
};