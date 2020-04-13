// TwoSum.cpp
// Author: hyan23
// 2019.03.03
// https://leetcode.com/problems/two-sum/

// Runtime: 20 ms (41.58% faster)
// Best solution: 0 ms

#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution
{
  public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        multimap<int, int> numsMap;
        for (int i = 0; i < nums.size(); i++)
        {
            numsMap.insert(pair<int, int>(nums[i], i));
        }

        vector<int> result;
        for (int i = 0; i < nums.size(); i++)
        {
            int difference = target - nums[i];
            int desiredCount = difference == nums[i] ? 2 : 1;
            if (numsMap.count(difference) >= desiredCount)
            {
                auto iter = numsMap.find(difference);
                while (iter != numsMap.end())
                {
                    if (iter->second != i)
                    {
                        result.push_back(i);
                        result.push_back(iter->second);
                        break;
                    }
                    iter++;
                }
                break;
            }
        }
        return result;
    }
};

int main(int argc, char *argv[])
{
    (void)argc;
    (void)argv;

    vector<int> nums;
    nums.push_back(2);
    nums.push_back(7);
    nums.push_back(11);
    nums.push_back(15);
    int target = 9;

    vector<int> result = Solution().twoSum(nums, target);
    for (int i = 0; i < result.size(); i++)
    {
        cout << result[i] << " ";
    }

    return 0;
}