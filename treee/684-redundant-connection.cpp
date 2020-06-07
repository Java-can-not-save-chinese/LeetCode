class Solution {
public:
    int find(int x) {
        if (fa[x] == 0)
            return x;
        return find(fa[x]);
    }
    
    bool join(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            fa[a] = b;
            return true;
        }
        return false;
    }
    
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<int> ret(2);
        for (int i = 0; i < edges.size(); ++i) {
            int x = edges[i][0];
            int y = edges[i][1];
            bool b = join(x, y);
            if (!b) {
                ret[0] = x;
                ret[1] = y;
            }
        }
        return ret;
    }
    
    int fa[1005];
};