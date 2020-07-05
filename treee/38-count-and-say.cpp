class Solution {
public:
    string countAndSay(int n) {
        return countAndSay(n, string("1"));
    }

    string countAndSay(int n, string s) {
        if (n == 1)
            return s;
        return countAndSay(n - 1, say(s));
    }

    string say(string s) {
        string ret = "";
        char cur = ' ';
        int cnt = 0;

        for (auto c : s) {
            if (c != cur) {
                if (cnt != 0) {
                    ret += to_string(cnt);
                    ret += to_string(cur - 48);
                }
                cur = c;
                cnt = 1;
            }
            else {
                cnt ++;
            }
        }

        if (cnt != 0) {
            ret += to_string(cnt);
            ret += to_string(cur - 48);
        }

        return ret;
    }
};
