// IntegerToRoman.cpp
// Author: hyan23
// 2019.03.09
// https://leetcode.com/problems/integer-to-roman/

// Runtime: 48 ms
// Best solution: 0 ms

#include <iostream>

using namespace std;

/*
* Symbol       Value
* I             1
* V             5
* X             10
* L             50
* C             100
* D             500
* M             1000
*/

class Solution {
public:
    string intToRoman(int num) {
        string lut[4][11] = { { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" },
        { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C" },
        { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M" },
        { "", "M", "MM", "MMM", "", "", "", "", "", "", "" }};
        string result = "";
        int weight = 0;
        while (num > 0)
        {
            int rem = num % 10;
            result = lut[weight][rem] + result;
            num /= 10;
            weight ++;
        }
        return result;
    }
};

int main(int argc, char *argv[])
{
    (void)argc;
    (void)argv;

    cout << Solution().intToRoman(3) << endl;
    cout << Solution().intToRoman(4) << endl;
    cout << Solution().intToRoman(9) << endl;
    cout << Solution().intToRoman(58) << endl;
    cout << Solution().intToRoman(1994) << endl;
    cout << Solution().intToRoman(10) << endl;

    return 0;
}