class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if (isSelfDivide(i)) res.add(i);
        }
        return res;
    }

    public boolean isSelfDivide(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        for(int i = 0; i < len; i++) {
            char c = str.charAt(i);
            int temp = Integer.valueOf("" + c);
            if (temp == 0 || num % temp != 0) return false;
        }
        return true;
    }
}