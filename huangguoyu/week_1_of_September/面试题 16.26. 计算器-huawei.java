public class Solution02 {
    static Set<Character> set = new HashSet<>();
    static {
        set.add('+');
        set.add('-');
    }
    public int calculate(String s) {
        int res = 0;
        String replace = s.replace(" ", "");
        // 所有的操作数
        List<Integer> nums = Arrays.
                stream(replace.split("[+-]")).map(Integer::valueOf).
                collect(Collectors.toList());
        int idx = 0;
        res = nums.get(0);
        // op
        String[] split = replace.split("\\d");
        for (String op : split) {
            if ("".equals(op)) continue;
            if (op.equals("-")) {
                res -= nums.get(idx++);
            }
            if (op.equals("+")) {
                res += nums.get(idx++);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution02 solution = new Solution02();
        System.out.println(solution.calculate("1-11+2-15+15"));

    }
}