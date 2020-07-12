class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int lst = nums.size() - 1;
        int len = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] == val) {
                if (i < lst) {
                    swap(nums[i], nums[lst]);
                    --i;
                    --lst;
                }
                else {
                    break;
                }
            }
            else {
                ++len;
            }
        }
        return len;
    }
};