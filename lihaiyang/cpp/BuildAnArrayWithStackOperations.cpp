// BuildAnArrayWithStackOperations.cpp
// Author: hyan23
// 2020.05.31
// https://leetcode.com/problems/build-an-array-with-stack-operations/

// Runtime: 4 ms, faster than 65.55% of C++ online submissions for Build an Array With Stack Operations.
// Memory Usage: 8 MB, less than 100.00 % of C++ online submissions for Build an Array With Stack Operations.

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	vector<string> buildArray(vector<int>& target, int n) {
		vector<string> ops;
		int i = 1;
		auto iter = target.cbegin();
		for (int i = 1; i <= n && iter != target.cend(); i++) {
			ops.push_back("Push");
			if (i != *iter) {
				ops.push_back("Pop");
			}
			else {
				iter++;
			}
		}
		return ops;
	}
};

int main(void)
{
	return 0;
}