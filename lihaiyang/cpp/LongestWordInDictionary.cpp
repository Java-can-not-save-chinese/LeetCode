// LongestWordInDictionary.cpp
// Author: hyan23
// 2020.06.14
// https://leetcode.com/problems/longest-word-in-dictionary/

// Runtime: 376 ms, faster than 9.92% of C++ online submissions for Longest Word in Dictionary.
// Memory Usage: 44 MB, less than 12.33 % of C++ online submissions for Longest Word in Dictionary.

#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

bool cmp(string a, string b) {
	if (a.length() == b.length()) {
		return a < b;
	}
	else {
		return a.length() > b.length();
	}
}

class Solution {
public:
	string longestWord(vector<string>& words) {
		map<string, int> mp;
		for (auto iter = words.cbegin(); iter != words.cend(); iter++) {
			mp[*iter]++;
		}

		//  If there is more than one possible answer, return the longest word with the smallest lexicographical order.
		sort(words.begin(), words.end(), cmp);

		// If there is no answer, return the empty string.
		string ans = "";
		for (auto iter = words.cbegin(); iter != words.cend(); iter++) {
			// cout << *iter << endl;
			string word = *iter;
			char letters[31];
#ifdef _MSC_VER
			strncpy_s(letters, word.c_str(), 30);
#else

			strncpy(letters, word.c_str(), 30);
#endif

			ans = *iter;
			for (int i = word.length() - 1; i > 0; i--) {
				letters[i] = '\0';
				if (mp.find(letters) == mp.cend()) {
					ans = "";
					break;
				}
			}

			if (ans.length() > 0) {
				break;
			}
		}
		return ans;
	}
};

int main(void)
{
	Solution sln;
	vector<string> vec;
	vec.push_back("w");
	vec.push_back("wo");
	vec.push_back("wor");
	vec.push_back("worl");
	vec.push_back("world");
	vec.push_back("hello");

	cout << sln.longestWord(vec) << endl;

	return 0;
}
