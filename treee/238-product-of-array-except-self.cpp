class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> ret(nums.size(), 1);
        int t = 1;
        
        for (int i = 1; i < nums.size(); ++i)
            ret[i] = ret[i - 1] * nums[i - 1];
        for (int i = nums.size() - 1; i >= 0; --i) {
            ret[i] *= t;
            t *= nums[i];
        }
        
        return ret;
    }
};