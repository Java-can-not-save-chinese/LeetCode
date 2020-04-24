class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.size() == 0)
            return 0;
        
        int ret = 0;
        vector<vector<int>> vis(grid.size(), vector<int>(grid[0].size()));
        int dir[4][2] = { -1, 0, 0, -1, 0, 1, 1, 0 };
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[i].size(); ++j) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    vis[i][j] = 1;
                    queue<pair<int, int>> que;
                    que.push(make_pair(i, j));
                    while (!que.empty()) {
                        auto t = que.front();
                        que.pop();
                        for (int k = 0; k < 4; ++k) {
                            int x = dir[k][0] + t.first;
                            int y = dir[k][1] + t.second;
                            if (x >= 0 && x < grid.size() && y >= 0 && y < grid[x].size() && grid[x][y] == '1' && !vis[x][y]) {
                                vis[x][y] = 1;
                                que.push(make_pair(x, y));
                            }
                        }
                    }
                    ++ret;
                }
            }
        }
        
        return ret;
    }
};