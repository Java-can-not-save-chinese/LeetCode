// RobotReturnToOrigin.cpp
// Author: hyan23
// 2020.06.21
// https://leetcode.com/problems/robot-return-to-origin/

/*
Runtime: 28 ms, faster than 69.48% of C++ online submissions for Robot Return to Origin.
Memory Usage: 8 MB, less than 84.92% of C++ online submissions for Robot Return to Origin.
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	bool judgeCircle(string moves)
	{
		int hori = 0, vert = 0;

		for (auto ch : moves) {
			switch (ch)
			{
			case 'U':
				vert++;
				break;
			case 'D':
				vert--;
				break;
			case 'L':
				hori--;
				break;
			case 'R':
				hori++;
				break;
			default:
				break;
			}
		}

		return hori == 0 && vert == 0;
	}
};

int main(void)
{
	return 0;
}
