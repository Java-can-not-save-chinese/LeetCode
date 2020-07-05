// ShuffleTheArray.cpp
// Author: hyan23
// 2020.06.28
// https://leetcode.com/problems/shuffle-the-array/

/*
Runtime: 8 ms, faster than 94.71% of C++ online submissions for Shuffle the Array.
Memory Usage: 9.9 MB, less than 100.00% of C++ online submissions for Shuffle the Array.
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	vector<int> shuffle(vector<int>& nums, int n) {
		vector<int> ans;
		for (int i = 0; i < n; i++) {
			ans.push_back(nums[i]);
			ans.push_back(nums[n + i]);
		}
		return ans;
	}
};

int main(void)
{
	return 0;
}
