class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int num = nums[0];
        int cnt = 0;
        
        for (auto n : nums) {
            if (num == n) {
                ++cnt;
            }
            else {
                if (cnt == 0) {
                    num = n;
                }
                else {
                    --cnt;
                }
            }
        }
        return num;
    }
};

/*
Runtime: 16 ms, faster than 95.92% of C++ online submissions for Majority Element.
Memory Usage: 9 MB, less than 100.00% of C++ online submissions for Majority Element.
*/