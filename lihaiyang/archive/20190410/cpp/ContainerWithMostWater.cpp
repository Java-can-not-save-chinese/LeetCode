// ContainerWithMostWater.cpp
// Author: hyan23
// 2019.03.09
// https://leetcode.com/problems/container-with-most-water/
// I have consulted the official solution for this problem

// Runtime: 20 ms (65.38% faster)
// Best solution: 0 ms

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        if (height.size() < 2)
        {
            return 0;
        }
        int i = 0, j = height.size() - 1;
        int result = 0;
        while (i < j)
        {
            int area = min(height[i], height[j]) * (j - i);
            result = area > result ? area : result;
            if (height[i] > height[j])
            {
                j --;
            }
            else
            {
                i ++;
            }
        }
        return result;
    }
};

int main(int argc, char *argv[])
{
    (void)argc;
    (void)argv;

    vector<int> height = {1,8,6,2,5,4,8,3,7};
    cout << Solution().maxArea(height) << endl;

    return 0;
}