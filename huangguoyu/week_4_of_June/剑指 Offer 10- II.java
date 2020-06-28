class Solution {
    public int numWays(int n) {
        return fib(n);
    }

     public Map<Integer, Integer> resMap = new HashMap<>();
    {
        resMap.put(0,1);
        resMap.put(1,1);
        resMap.put(2,2);
    }
    public int fib(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (resMap.get(n) != null) return resMap.get(n);
        if (resMap.get(n - 1) != null) return (resMap.get(n - 1) + resMap.get(n - 2)) % 1000000007;
        else {
            int res = (fib(n - 1) + fib(n - 2))  % 1000000007;
            resMap.put(n, res);
            return res;
        }
    }
}