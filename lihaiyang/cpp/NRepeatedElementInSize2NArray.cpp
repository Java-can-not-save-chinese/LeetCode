// NRepeatedElementInSize2NArray.cpp
// Author: hyan23
// 2020.06.21
// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/

/*
Runtime: 72 ms, faster than 70.69% of C++ online submissions for N-Repeated Element in Size 2N Array.
Memory Usage: 24.9 MB, less than 37.93% of C++ online submissions for N-Repeated Element in Size 2N Array.
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

class Solution {
public:
	int repeatedNTimes(vector<int>& A) {
		map<int, int> mp;
		for (auto elem : A) {
			if (mp.find(elem) != mp.end()) {
				return elem;
			}
			mp[elem]++;
		}
	}
};

int main(void)
{
	return 0;
}
