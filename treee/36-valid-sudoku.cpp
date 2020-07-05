class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int vis[9];

        for (int i = 0; i < 9; ++i) {
            memset(vis, 0, sizeof(vis));
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    if (vis[t])
                        return false;
                    vis[t] = 1;
                }
            }
        }

        for (int i = 0; i < 9; ++i) {
            memset(vis, 0, sizeof(vis));
            for (int j = 0; j < 9; ++j) {
                if (board[j][i] != '.') {
                    int t = board[j][i] - '1';
                    if (vis[t])
                        return false;
                    vis[t] = 1;
                }
            }
        }

        for (int k = 0; k < 9; ++k) {
            memset(vis, 0, sizeof(vis));
            for (int i = 3 * (k / 3); i < 3 * (k / 3) + 3; ++i) {
                for (int j = 3 * (k % 3); j < 3 * (k % 3) + 3; ++j) {
                    if (board[i][j] != '.') {
                        int t = board[i][j] - '1';
                        if (vis[t])
                            return false;
                        vis[t] = 1;
                    }
                }
            }
        }

        return true;
    }
};
