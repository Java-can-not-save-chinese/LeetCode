// RunningSumOf1DArray.cpp
// Author: hyan23
// 2020.06.28
// https://leetcode.com/problems/running-sum-of-1d-array/

/*
Runtime: 4 ms, faster than 92.40% of C++ online submissions for Running Sum of 1d Array.
Memory Usage: 8.6 MB, less than 40.00% of C++ online submissions for Running Sum of 1d Array.
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	vector<int> runningSum(vector<int>& nums) {
		vector<int> ans;
		int sum = 0;
		for (auto elem : nums) {
			sum += elem;
			ans.push_back(sum);
		}
		return ans;
	}
};

int main(void)
{
	return 0;
}
