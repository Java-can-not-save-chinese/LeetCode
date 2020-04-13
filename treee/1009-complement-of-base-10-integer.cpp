class Solution {
public:
    int bitwiseComplement(int N) {
        if (N == 0)
            return 1;
        
        int ret = 0, idx = 0;
        vector<int> vec;
        while (N) {
            vec.push_back(N % 2);
            N /= 2;
        }
        
        for (int i = 0; i < vec.size(); ++i) {
            ret += pow(2, idx++) * (vec[i] == 0);
        }
        return ret;
    }
};