// StringToInteger.cpp
// Author: hyan23
// 2019.03.04
// https://leetcode.com/problems/string-to-integer-atoi/

// Runtime: 16 ms
// Best solution: 0 ms

#include <iostream>
#include <climits>

using namespace std;

class Solution
{
  public:
    int myAtoi(string str)
    {
        char sign = '+';
        bool started = false;
        int result = 0;

        for (int i = 0; i < str.length(); i++)
        {
            if (!started)
            {
                if (str[i] != ' ')
                {
                    started = true;
                    if (str[i] == '+' || str[i] == '-')
                    {
                        sign = str[i];
                        continue;
                    }
                }
            }
            if (started)
            {
                if (!isdigit(str[i]))
                {
                    break;
                }
                int digit = str[i] - '0';
                if (sign == '-')
                {
                    digit = -digit;
                }
                // INT_MAX: 2147483647
                if (result > INT_MAX / 10 || (result > INT_MAX / 10 - 1 && digit > 7))
                {
                    result = INT_MAX;
                    break;
                }
                // INT_MIN: -2147483648
                if (result < INT_MIN / 10 || (result < INT_MIN / 10 + 1 && digit < -8))
                {
                    result = INT_MIN;
                    break;
                }
                result = result * 10 + digit;
            }
        }
        return result;
    }
};

int main(int argc, char *argv[])
{
    (void)argc;
    (void)argv;

    cout << Solution().myAtoi("42") << endl;
    cout << Solution().myAtoi("   -42") << endl;
    cout << Solution().myAtoi("4193 with words") << endl;
    cout << Solution().myAtoi("words and 987") << endl;
    cout << Solution().myAtoi("-91283472332") << endl;

    return 0;
}