// SortArrayByParity.cpp
// Author: hyan23
// 2020.06.21
// https://leetcode.com/problems/sort-array-by-parity/

/*
Runtime: 32 ms, faster than 16.26% of C++ online submissions for Sort Array By Parity.
Memory Usage: 16.2 MB, less than 70.71% of C++ online submissions for Sort Array By Parity.
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	vector<int> sortArrayByParity(vector<int>& A)
	{
		vector<int> B(A.size());
		int even = 0, odd = B.size()-1;

		for (auto elem : A) {
			if ((elem & 1) == 0) {
				B[even++] = elem;
			}
			else {
				B[odd--] = elem;
			}
		}

		return B;
	}
};

int main(void)
{
	return 0;
}
