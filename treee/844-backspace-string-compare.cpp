class Solution {
public:
    bool backspaceCompare(string S, string T) {
        int sp1 = 0, sp2 = 0;
        int i = S.length() - 1, j = T.length() - 1;
        for (; i >= 0 || j >= 0; --i, --j) {
            while (i >= 0 && (S[i] == '#' || sp1))
                S[i--] == '#' ? ++sp1 : --sp1;
            while (j >= 0 && (T[j] == '#' || sp2))
                T[j--] == '#' ? ++sp2 : --sp2;
            if (i < 0 || j < 0)
                return i == j;
            if (S[i] != T[j])
                return false;
        }
        return i == j;
    }
};