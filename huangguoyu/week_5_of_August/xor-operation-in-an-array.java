class Solution {
    public int xorOperation(int n, int start) {
        int temp = start;
        int res = temp;
        for(int i = 1; i < n; i++) {
            res ^= (start + 2*i);
        }
        return res;
    }
}