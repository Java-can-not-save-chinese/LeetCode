// KidsWithTheGreatestNumberOfCandies.cpp
// Author: hyan23
// 2020.05.31
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

// Runtime: 4 ms, faster than 87.79% of C++ online submissions for Kids With the Greatest Number of Candies.
// Memory Usage: 8.9 MB, less than 100.00 % of C++ online submissions for Kids With the Greatest Number of Candies.

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
		int max = *std::max_element(candies.rbegin(), candies.rend());
		vector<bool> res;
		for_each(candies.cbegin(), candies.cend(), [&](auto e) {res.push_back(e + extraCandies >= max); });
		return res;
	}
};

int main(void)
{
	return 0;
}