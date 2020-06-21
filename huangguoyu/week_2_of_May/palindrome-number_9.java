class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int p = 0, q = s.length() - 1;
        while(p <= q) {
            if (s.charAt(p) == s.charAt(q)) {
                p++;
                q--;
            } else {
                return false;
            }
        }
        return true;
    }
}