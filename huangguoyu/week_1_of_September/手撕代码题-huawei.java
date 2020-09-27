public class Solution {

    private int res = 0;

    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        //select 1 or 2
        backTrace(s.substring(1));
        backTrace(s.substring(2));
        return res;
    }
    //12345
    public void backTrace(String route) {
        // r > 0 and r <= 26
        if (route.length() == 0) {
            res++;
            return;
        }
        if (route.startsWith("0")) return;
        // select 1
        String r1 = route.substring(0, 1);
        backTrace(route.substring(1));
        // select 2
        if (route.length() < 2) return;
        String r2 = route.substring(0, 2);
        Integer r2Code = Integer.valueOf(r2);
        if (r2Code <= 0 || r2Code > 26) return;
        backTrace(route.substring(2));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.numDecodings("1"));
        System.out.println(solution.numDecodings("1223"));
//        System.out.println(solution.numDecodings("10"));
    }
}