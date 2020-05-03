class Solution {
public:
    string addBinary(string a, string b) {
        string ret = "";
        bool carry = false;
        reverse(a.begin(), a.end());
        reverse(b.begin(), b.end());
        int i = 0;
        for (; i < a.length() && i < b.length(); ++i) {
            if (a[i] == '1' && b[i] == '1') {
                ret += carry ? "1" : "0";
                carry = true;
            }
            else if (a[i] == '1' || b[i] == '1') {
                ret += carry ? "0" : "1";
            }
            else {
                if (carry) {
                    ret += "1";
                    carry = false;
                }
                else {
                    ret += "0";
                }
            }
        }
        
        while (i < a.length()) {
            if (a[i] == '1') {
                ret += carry ? "0" : "1";
            }
            else {
                if (carry) {
                    carry = false;
                    ret += "1";
                }
                else {
                    ret += "0";
                }
            }
            ++i;
        }
        
        while (i < b.length()) {
            if (b[i] == '1') {
                ret += carry ? "0" : "1";
            }
            else {
                if (carry) {
                    carry = false;
                    ret += "1";
                }
                else {
                    ret += "0";
                }
            }
            ++i;
        }
        
        if (carry)
            ret += "1";
        
        reverse(ret.begin(), ret.end());
        return ret;
    }
};