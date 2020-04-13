// RomanToInteger.cpp
// Author: hyan23
// 2019.03.09
// https://leetcode.com/problems/roman-to-integer/

// Runtime: 48 ms
// Best solution: 0 ms

#include <iostream>
#include <map>

using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        int I = 0, V = 0, X = 0, L = 0, C = 0, D = 0, M = 0;
        for (int i = 0; i < s.length(); i ++)
        {
            switch (s[i])
            {
                case 'I':
                    I += 1;
                    break;
                case 'V':
                    V += 5 - (I << 1);
                    break;
                case 'X':
                    X += 10 - (I << 1);
                    break;
                case 'L':
                    L += 50 - (X << 1);
                    break;
                case 'C':
                    C += 100 - (X << 1);
                    break;
                case 'D':
                    D += 500 - (C << 1);
                    break;
                case 'M':
                    M += 1000 - (C << 1);
                    break;
                default:
                    break;
            }
        }
        return I + V + X + L + C + D + M;
    }
};

int main(int argc, char *argv[])
{
    (void)argc;
    (void)argv;

    cout << Solution().romanToInt("III") << endl;
    cout << Solution().romanToInt("IV") << endl;
    cout << Solution().romanToInt("IX") << endl;
    cout << Solution().romanToInt("LVIII") << endl;
    cout << Solution().romanToInt("MCMXCIV") << endl;

    return 0;
}