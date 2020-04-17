// LongestPalindromic.cpp
// Author: hyan23
// 2019.03.04
// https://leetcode.com/problems/longest-palindromic-substring/

// Runtime: 20 ms (77.14% faster)
// Best solution: 0 ms

#include <iostream>

using namespace std;

class Solution
{
  public:
    string longestPalindrome(string s)
    {
        int maxLength = 0, start = 0;
        for (int i = 0; i < s.length(); i++)
        {
            // match aba type
            int m = i, n = i;
            int length = 1;
            while (true)
            {
                m--, n++;
                if (m < 0 || n >= s.length())
                {
                    break;
                }
                if (s[m] != s[n])
                {
                    break;
                }
            }
            length = n - m - 1;
            if (length > maxLength)
            {
                maxLength = length;
                start = m + 1;
            }
            // match abba type
            m = i, n = i + 1;
            length = 1;
            while (true)
            {
                if (s[m] != s[n])
                {
                    break;
                }
                m--, n++;
                if (m < 0 || n >= s.length())
                {
                    break;
                }
            }
            length = n - m - 1;
            if (length > maxLength)
            {
                maxLength = length;
                start = m + 1;
            }
        }
        return s.substr(start, maxLength);
    }
};

int main(int argc, char *argv[])
{
    (void)argc;
    (void)argv;

    cout << Solution().longestPalindrome("babad") << endl;
    cout << Solution().longestPalindrome("cbbd") << endl;

    return 0;
}