class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ret;
        
        unordered_map<string, vector<string>> mp;
        
        for (auto&& s : strs) {
            string key = s;
            sort(key.begin(), key.end());
            mp[key].push_back(move(s));
        }
        
        for (auto&& it : mp) {
            ret.push_back(move(it.second));
        }
        
        return ret;
    }
};