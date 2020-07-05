class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> sets = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != null) {
                sets.add(c);
                map.remove(c);
            } else if (!sets.contains(c)){
                map.put(c, i);
            }
        }
        if (map.keySet().size() == 0) return -1;
        return map.values().stream().min(Comparator.comparingInt(a -> a)).get();
    }
}