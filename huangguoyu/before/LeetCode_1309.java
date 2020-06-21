class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0;) {
            char c = s.charAt(i);
            if (c == '#') {
                int num = Integer.valueOf("" + s.charAt(i - 2) + s.charAt(i - 1));
                c = (char)(num + 'a' - 1);
                i-=3;
            } else {
                c = (char)(Integer.valueOf("" + c) + 'a' - 1);
                i--;
            }
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}