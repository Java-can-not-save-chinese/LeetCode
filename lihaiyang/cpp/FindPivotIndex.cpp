// FindPivotIndex.cpp
// Author: hyan23
// 2020.06.14
// https://leetcode.com/problems/find-pivot-index/

// Runtime: 60 ms, faster than 16.09% of C++ online submissions for Find Pivot Index.
// Memory Usage: 32.1 MB, less than 7.14 % of C++ online submissions for Find Pivot Index.

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	int pivotIndex(vector<int>& nums) {
		vector<int> from_left(nums.size() + 2), from_right(nums.size() + 2);
		from_left[0] = from_left[nums.size() + 1] = from_right[0] = from_right[nums.size() + 1] = 0;
		int sum_from_left = 0, sum_from_right = 0;

		for (int i = 0; i < nums.size(); i++) {
			sum_from_left += nums[i];
			sum_from_right += nums[nums.size() - 1 - i];
			from_left[i + 1] = sum_from_left;
			from_right[nums.size() - 1 - i + 1] = sum_from_right;
		}

		for (int i = 1; i <= nums.size(); i++) {
			if (from_left[i - 1] == from_right[i + 1]) {
				return i - 1;
			}
		}

		return -1;
	}
};

int main(void)
{
	Solution sln;
	vector<int> vec;
	vec.push_back(1);
	cout << sln.pivotIndex(vec);

	return 0;
}
