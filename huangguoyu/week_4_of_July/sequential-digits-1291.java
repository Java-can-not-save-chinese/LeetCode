class Solution {
    List<Integer> res = new ArrayList<>();
    int low, high;
    public List<Integer> sequentialDigits(int low, int high) {
        this.low = low;
        this.high = high;
        for(int i = 1; i < 10; i++) backtrace(String.valueOf(i), i);
        Collections.sort(res);
        return res;
    }

    public void backtrace(String routes, Integer cur) {
        Integer temp = Integer.valueOf(routes);
        if (temp >= low &&  temp <= high) res.add(temp);
        else if (temp > high || cur >= 9) return;
        if (cur != 9)
            backtrace(routes + (cur + 1), cur + 1);
    }
}