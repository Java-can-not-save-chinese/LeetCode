class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            if (map.get(c) != null) map.remove(c);
            else map.put(c, 1);
        }
        if (map.size() > 1) return false;
        else return true;
    }
}