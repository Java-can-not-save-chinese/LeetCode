class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> ret;
        combinator(candidates, vector<int>(), 0, target, ret);
        sort(ret.begin(), ret.end());
        auto it = unique(ret.begin(), ret.end());
        ret.resize(distance(ret.begin(), it));
        return ret;
    }

    void combinator(vector<int>& candidates, vector<int> cur_vec, int cur_idx, int target, vector<vector<int>>& ret) {
        int s = accumulate(cur_vec.begin(), cur_vec.end(), 0);
        if (s == target) {
            sort(cur_vec.begin(), cur_vec.end());
            ret.push_back(cur_vec);
            return;
        }

        for (; cur_idx < candidates.size(); ++cur_idx) {
            if (candidates[cur_idx] + s <= target) {
                cur_vec.push_back(candidates[cur_idx]);
                combinator(candidates, cur_vec, cur_idx + 1, target, ret);
                cur_vec.pop_back();
            }
        }
    }
};