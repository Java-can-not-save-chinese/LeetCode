// LongestSubstringOpt.cpp
// Author: hyan23
// 2019.03.03
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Runtime: 16 ms (70.58% faster)
// Best solution: 0 ms

#include <iostream>
#include <cstring>

using namespace std;

class Solution
{
  public:
    int lengthOfLongestSubstring(string s)
    {
        int i = 0, j = 0, charMap[256], result = 0;
        memset(charMap, -1, sizeof (charMap));
        while (j < s.length())
        {
            i = charMap[s[j]] >= i ? charMap[s[j]] + 1 : i;
            charMap[s[j]] = j;
            result = j - i + 1 > result ? j - i + 1 : result;
            j++;
        }
        return result;
    }
};

int main(int argc, char *argv[])
{
    (void)argc;
    (void)argv;

    cout << Solution().lengthOfLongestSubstring("abcabcbb") << endl;
    cout << Solution().lengthOfLongestSubstring("bbbbb") << endl;
    cout << Solution().lengthOfLongestSubstring("pwwkew") << endl;
    cout << Solution().lengthOfLongestSubstring("aab") << endl;
    cout << Solution().lengthOfLongestSubstring("tmmzuxt") << endl;
    cout << Solution().lengthOfLongestSubstring("abba") << endl;

    return 0;
}