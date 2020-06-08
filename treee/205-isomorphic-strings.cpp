class Solution {
public:
    bool isIsomorphic(string s, string t) {
        map<char, char> mp1, mp2;
        for (int i = 0; i < s.length(); ++i) {
            if (mp1.count(s[i]) == 0)
                mp1[s[i]] = t[i];
            if (mp2.count(t[i]) == 0)
                mp2[t[i]] = s[i];
            
            if (mp1[s[i]] != t[i])
                return false;
            if (mp2[t[i]] != s[i])
                return false;
        }
        return true;
    }
};