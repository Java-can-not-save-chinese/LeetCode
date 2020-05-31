// DestinationCity.cpp
// Author: hyan23
// 2020.05.31
// https://leetcode.com/problems/destination-city/

// Runtime: 32 ms, faster than 45.94% of C++ online submissions for Destination City.
// Memory Usage: 12.1 MB, less than 100.00 % of C++ online submissions for Destination City.

#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

class Solution {
public:
	string destCity(vector<vector<string>>& paths) {
		set<string> s;
		for_each(paths.cbegin(), paths.cend(), [&](auto e) { s.insert(e[1]); });
		for_each(paths.cbegin(), paths.cend(), [&](auto e) { s.erase(e[0]); });
		return *s.begin();
	}
};

int main(void)
{
	return 0;
}