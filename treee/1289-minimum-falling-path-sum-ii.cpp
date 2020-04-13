class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& arr) {
        int fst_min = 0, snd_min = 0, idx = -1;
        for (int i = 0; i < arr.size(); ++i) {
            int fst_min_tmp = INT_MAX, snd_min_tmp = INT_MAX, idx_tmp = -1;
            for (int j = 0; j < arr[0].size(); ++j) {
                int min_value = j == idx ? snd_min : fst_min;
                min_value += arr[i][j];
                
                if (min_value < fst_min_tmp) {
                    snd_min_tmp = fst_min_tmp;
                    fst_min_tmp = min_value;
                    idx_tmp = j;
                }
                else {
                    snd_min_tmp = min(snd_min_tmp, min_value);
                }
            }
            fst_min = fst_min_tmp;
            snd_min = snd_min_tmp;
            idx = idx_tmp;
        }
        return fst_min;
    }
};