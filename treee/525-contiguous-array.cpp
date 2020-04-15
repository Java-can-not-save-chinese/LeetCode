class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int ret = 0, sum = 0;
        unordered_map<int, int> mp = { { 0, -1 } };
        for (int i = 0; i < nums.size(); ++i) {
            sum += nums[i] == 1 ? 1 : -1;
            if (mp.count(sum))
                ret = max(ret, i - mp[sum]);
            else
                mp[sum] = i;
        }
        return ret;
    }
};