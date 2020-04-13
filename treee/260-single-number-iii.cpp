class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int diff = accumulate(nums.begin(), nums.end(), 0, bit_xor<int>());
        diff &= -diff;
        
        vector<int> ret(2, 0);
        for (auto num : nums) {
            if ((diff & num) == 0)
                ret[0] ^= num;
            else
                ret[1] ^= num;
        }
        
        return ret;
    }
};