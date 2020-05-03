class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int i = nums.size() - 1;
        while (i >= 0) {
            if (nums[i] < target)
                break;
            --i;
        }
        return i + 1;
    }
};