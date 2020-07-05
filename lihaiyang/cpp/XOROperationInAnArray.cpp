// XOROperationInAnArray.cpp
// Author: hyan23
// 2020.06.28
// https://leetcode.com/problems/xor-operation-in-an-array/

/*
Runtime: 0 ms, faster than 100.00% of C++ online submissions for XOR Operation in an Array.
Memory Usage: 6.1 MB, less than 100.00% of C++ online submissions for XOR Operation in an Array.
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	int xorOperation(int n, int start) {
		int ans = 0, step = 0;
		for (int i = 0; i < n; i++) {
			step = start + 2 * i;
			ans ^= step;
		}
		return ans;
	}
};

int main(void)
{
	return 0;
}
