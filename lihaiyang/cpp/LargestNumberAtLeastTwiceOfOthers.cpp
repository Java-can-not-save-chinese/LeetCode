// LargestNumberAtLeastTwiceOfOthers.cpp
// Author: hyan23
// 2020.06.14
// https://leetcode.com/problems/largest-number-at-least-twice-of-others/

// Runtime: 12 ms, faster than 26.71% of C++ online submissions for Largest Number At Least Twice of Others.
// Memory Usage: 11.2 MB, less than 58.89 % of C++ online submissions for Largest Number At Least Twice of Others.

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	int dominantIndex(vector<int>& nums) {
		int largest = 0, index = 0;
		for (int i = 0; i < nums.size(); i++) {
			if (nums[i] > largest) {
				largest = nums[i];
				index = i;
			}
		}
		for (int i = 0; i < nums.size(); i++) {
			if (i != index && nums[i] * 2 > largest) {
				return -1;
			}
		}
		return index;
	}
};

int main(void)
{
	return 0;
}
