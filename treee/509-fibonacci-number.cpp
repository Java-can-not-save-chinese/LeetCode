class Solution {
public:
    int fib(int N) {
        if (N < 1)
            return N;
        
        int a = 0, b = 1;
        for (int i = 1; i < N; ++i) {
            int t = b;
            b = a + b;
            a = t;
        }
        
        return b;
    }
};