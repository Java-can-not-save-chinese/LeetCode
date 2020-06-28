class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int ret = 0;
        vector<vector<int>> vec(matrix.size());
        for_each(vec.begin(), vec.end(), [&](auto& a) {
            a.resize(matrix[0].size());
        });
        
        auto min3 = [](int a, int b, int c) {
            return min(a, min(b, c));
        };
        
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix[i].size(); ++j) {
                if (i == 0 || j == 0) {
                    vec[i][j] = matrix[i][j] - '0';
                }
                else if (matrix[i][j] == '1') {
                    vec[i][j] = min3(vec[i - 1][j - 1], vec[i - 1][j], vec[i][j - 1]) + 1;
                }
                ret = max(vec[i][j], ret);
            }
        }
        
        return ret * ret;
    }
};