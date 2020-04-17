class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int i = 0;
        while (i < nums.size()) {
            if (nums[i] != 0)
                break;
            ++i;
        }
        if (i == nums.size())
            return;
        
        int j = 0;
        while (i < nums.size() && j < nums.size()) {
            if (i < j) {
                ++i;
                while (i < nums.size() && nums[i] == 0)
                    ++i;
                continue;
            }
            if (nums[j] != 0) {
                ++j;
                continue;
            }
            
            swap(nums[i], nums[j]);
            while (i < nums.size() && nums[i] == 0)
                ++i;
            ++j;
        }
    }
};