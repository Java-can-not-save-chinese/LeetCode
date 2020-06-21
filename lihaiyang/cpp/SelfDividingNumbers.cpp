// SelfDividingNumbers.cpp
// Author: hyan23
// 2020.06.21
// https://leetcode.com/problems/self-dividing-numbers/

/*
Runtime: 0 ms, faster than 100.00% of C++ online submissions for Self Dividing Numbers.
Memory Usage: 6.5 MB, less than 45.50% of C++ online submissions for Self Dividing Numbers.
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	vector<int> selfDividingNumbers(int left, int right)
	{
		vector<int> ans;

		for (int cand = left; cand <= right; cand++) {
			int tmp = cand;
			bool isTrue = true;

			while (tmp != 0) {
				int digit = tmp % 10;
				if (digit == 0 || cand % digit != 0) {
					isTrue = false;
					break;
				}
				tmp /= 10;
			}

			if (isTrue) {
				ans.push_back(cand);
			}
		}

		return ans;
	}
};

int main(void)
{
	return 0;
}
