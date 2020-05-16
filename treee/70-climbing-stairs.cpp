class Solution {
public:
    int climbStairs(int n) {
        int a = 1, b = 1;
        for (int i = 2; i <= n; ++i) {
            int r = a + b;
            a = b;
            b = r;
        }
        return b;
    }
};