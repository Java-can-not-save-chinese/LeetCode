class Solution {

    public Map<Integer, Integer> resMap = new HashMap<>();
    {
        resMap.put(0,0);
        resMap.put(1,1);
    }
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (resMap.get(n) != null) return resMap.get(n);
        if (resMap.get(n - 1) != null) return (resMap.get(n - 1) + resMap.get(n - 2)) % 1000000007;
        else {
            int res = (fib(n - 1) + fib(n - 2))  % 1000000007;
            resMap.put(n, res);
            return res;
        }
    }
}