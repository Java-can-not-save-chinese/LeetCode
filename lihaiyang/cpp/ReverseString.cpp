// ReverseString.cpp
// Author: hyan23
// 2020.06.07
// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3350/

// Runtime: 48 ms
// Memory Usage: 23.5 MB

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	void reverseString(vector<char>& s) {
		int len = s.size();
		for (int i = 0; i < len / 2; i++) {
			char tmp = s[i];
			s[i] = s[len - 1 - i];
			s[len - 1 - i] = tmp;
		}
	}
};

int main(void)
{
	return 0;
}
