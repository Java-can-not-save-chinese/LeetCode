class Solution {
public:
    bool isHappy(int n) {
        map<int, bool> mp;
        while (true) {
            int r = 0;
            while (n) {
                int t = n % 10;
                r += t * t;
                n /= 10;
            }
            if (r == 1)
                return true;
            if (mp.find(r) == mp.end())
                mp[r] = true;
            else
                return false;
            n = r;
        }
    }
};