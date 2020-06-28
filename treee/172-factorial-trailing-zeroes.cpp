class Solution {
public:
    int trailingZeroes(int n) {
        int ret = 0;
        int base = 1;
        
        while (n / base >= 5) {
            base *= 5;
            ret += n / base;
        }
        
        return ret;
    }
};