class Solution {
public:
    int numberOfSteps (int num) {
        int ret = 0;
        while (num) {
            if (num % 2 == 0)
                num /= 2;
            else
                --num;
            ++ret;
        }
        return ret;
    }
};