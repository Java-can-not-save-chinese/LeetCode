// ReverseInteger.cpp
// Author: hyan23
// 2019.03.03
// https://leetcode.com/problems/reverse-integer/

// Runtime: 12 ms
// Best solution: 0 ms

#include <iostream>
#include <climits>

using namespace std;

class Solution
{
  public:
    int reverse(int x)
    {
        int sum = 0;
        while (x)
        {
            int remainder = x % 10;
            // INT_MAX: 2147483647
            if (sum > INT_MAX / 10 || (sum > INT_MAX / 10 - 1 && remainder > 7))
            {
                return 0;
            }
            // INT_MIN: -2147483648
            if (sum < INT_MIN / 10 || (sum < INT_MIN / 10 + 1 && remainder > 8))
            {
                return 0;
            }
            sum = sum * 10 + remainder;
            x = x / 10;
        }
        return sum;
    }
};

int main(int argc, char *argv[])
{
    (void)argc;
    (void)argv;

    cout << Solution().reverse(123) << endl;
    cout << Solution().reverse(-123) << endl;
    cout << Solution().reverse(120) << endl;

    return 0;
}