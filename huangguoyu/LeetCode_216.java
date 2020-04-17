class Solution {

    int k,n;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        res = new ArrayList<>();
        List<Integer> routes = new ArrayList<>();
        backtrace(routes, 1);
        return res;
    }

    public void backtrace(List<Integer> routes, int num) {
        // 是否满足条件
        if(routes.size() == k && routes.stream().mapToInt(s -> s).sum() == n) {
            res.add(new ArrayList<>(routes));
            return;
        }

        if (routes.size() > k) return;

        // 可选值
        for(int i = num; i <= 9; i++) {
            routes.add(i);
            backtrace(routes, i + 1);
            routes.remove(Integer.valueOf(i));
        }
    }
}