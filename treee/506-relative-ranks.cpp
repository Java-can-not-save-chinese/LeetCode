class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& nums) {
        vector<pair<int, int>> vec;
        vector<string> ret;
        ret.resize(nums.size());
        for (int i = 0; i < nums.size(); ++i) {
            vec.push_back(make_pair(nums[i], i));
        }
        stable_sort(vec.begin(), vec.end(), [](auto a, auto b) {
            return a.first > b.first;
        });

        for (int i = 0; i < nums.size(); ++i) {
            if (i == 0)
                ret[vec[i].second] = "Gold Medal";
            else if (i == 1)
                ret[vec[i].second] = "Silver Medal";
            else if (i == 2)
                ret[vec[i].second] = "Bronze Medal";
            else
                ret[vec[i].second] = to_string(i + 1);
        }

        return ret;
    }
};
