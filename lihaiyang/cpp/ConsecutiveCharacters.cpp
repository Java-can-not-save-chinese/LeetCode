// ConsecutiveCharacters.cpp
// Author: hyan23
// 2020.05.31
// https://leetcode.com/problems/consecutive-characters/

// Runtime: 8 ms, faster than 91.82% of C++ online submissions for Consecutive Characters.
// Memory Usage: 7 MB, less than 100.00 % of C++ online submissions for Consecutive Characters.

#include <iostream>
#include <algorithm>

using namespace std;

class Solution {
public:
	int maxPower(string s) {
		char old = '\0';
		int cnt = 0, max_cnt = 0;
		for (auto iter = s.cbegin(); iter != s.cend(); iter++) {
			if (*iter == old) {
				cnt++;
			}
			else {
				cnt = 1;
			}
			old = *iter;
			max_cnt = max(max_cnt, cnt);
		}
		return max_cnt;
	}
};

int main(void)
{
	return 0;
}