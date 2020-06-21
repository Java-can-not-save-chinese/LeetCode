// ShortestCompletingWord.cpp
// Author: hyan23
// 2020.06.14
// https://leetcode.com/problems/largest-number-at-least-twice-of-others/

// Runtime: 72 ms, faster than 23.86% of C++ online submissions for Shortest Completing Word.
// Memory Usage: 12.7 MB, less than 61.81 % of C++ online submissions for Shortest Completing Word.

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(string a, string b) {
	return a.length() < b.length();
}

class Solution {
public:
	string shortestCompletingWord(string licensePlate, vector<string>& words) {
		stable_sort(words.begin(), words.end(), cmp);

		for (auto word : words) {
			int cnt[26];
			memset(cnt, 0, sizeof(cnt));

			for (auto ch : word) {
				cnt[ch - 'a']++;
			}

			bool fail = false;
			for (auto ch : licensePlate) {
				if (islower(ch) || isupper(ch)) {
					ch = tolower(ch);
					if (--cnt[ch - 'a'] < 0) {
						fail = true;
						break;
					}
				}
			}

			if (!fail) {
				return word;
			}
		}

		return "";
	}
};

int main(void)
{
	return 0;
}
