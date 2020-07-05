class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> xs(nums.size());
        transform(nums.begin(), nums.end(), xs.begin(), [](int a) {
            return to_string(a);
        });
        
        sort(xs.begin(), xs.end(), [](string& a, string& b) {
            return a + b > b + a;
        });
        
        auto ret = accumulate(xs.begin(), xs.end(), string(""));
        
        if (ret[0] == '0' && ret.length() > 1)
            return string("0");
        
        return ret;
    }
};