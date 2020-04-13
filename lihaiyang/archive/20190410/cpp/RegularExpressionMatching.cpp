// RegularExpressionMatching.cpp
// Author: hyan23
// 2019.03.06
// https://leetcode.com/problems/regular-expression-matching/
// I have consulted the official solution for this problem

// Runtime: 24 ms (34.30% faster)
// Best solution: 0 ms

#include <iostream>
#include <cstring>

using namespace std;

class Solution
{
#define TRUE 1
#define FALSE 0
  public:
    bool isMatch(string s, string p)
    {
        char *(*note) = NULL;
        note = new char *[s.length() + 1];
        for (int i = 0; i < s.length() + 1; i++)
        {
            note[i] = new char[p.length() + 1];
            memset(note[i], -1, (p.length() + 1) * sizeof(char));
        }
        bool result = dp(note, s, p, 0, 0) == TRUE;
        for (int i = 0; i < s.length() + 1; i++)
        {
            delete[] note[i];
        }
        delete[] note;
        return result;
    }

    char dp(char *(*note), string s, string p, int i, int j)
    {
        if (note[i][j] != -1)
        {
            return note[i][j];
        }
        if (j == p.length())
        {
            return note[i][j] = i == s.length() ? TRUE : FALSE;
        }
        bool first_match = i < s.length() && (s[i] == p[j] || p[j] == '.');
        if (j + 1 < p.length() && p[j + 1] == '*')
        {
            return note[i][j] =
                       ((first_match && dp(note, s, p, i + 1, j)) ||
                        dp(note, s, p, i, j + 2))
                           ? TRUE
                           : FALSE;
        }
        else
        {
            return note[i][j] =
                       (first_match && dp(note, s, p, i + 1, j + 1)) ? TRUE : FALSE;
        }
    }
};

int main(int argc, char *argv[])
{
    (void)argc;
    (void)argv;

    cout << Solution().isMatch("aa", "a") << endl;
    cout << Solution().isMatch("aa", "a*") << endl;
    cout << Solution().isMatch("ab", ".*") << endl;
    cout << Solution().isMatch("aab", "c*a*b") << endl;
    cout << Solution().isMatch("mississippi", "mis*is*p*.") << endl;

    return 0;
}