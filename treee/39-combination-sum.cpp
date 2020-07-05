class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ret;
        combinator(candidates, vector<int>(), 0, target, ret);
        return ret;
    }

    void combinator(vector<int>& candidates, vector<int> cur_vec, int cur_idx, int target, vector<vector<int>>& ret) {
        int s = accumulate(cur_vec.begin(), cur_vec.end(), 0);
        if (s == target) {
            ret.push_back(cur_vec);
            return;
        }

        for (; cur_idx < candidates.size(); ++cur_idx) {
            if (candidates[cur_idx] + s <= target) {
                cur_vec.push_back(candidates[cur_idx]);
                combinator(candidates, cur_vec, cur_idx, target, ret);
                cur_vec.pop_back();
            }
        }
    }
};