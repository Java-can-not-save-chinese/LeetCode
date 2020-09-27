class Solution {
    int res = 0;
    int[] arrTemp; 
    public int sumOddLengthSubarrays(int[] arr) {
        arrTemp = arr;
        for(int i = 0; i < arr.length; i++) {
            res += arr[i];
            backTrace(i, i + 1);
        }
        return res;
    }

    public void backTrace(int s, int idx) {
        if (idx >= arrTemp.length || (idx - s + 1) > arrTemp.length) return;
        if (((idx - s + 1) % 2 ) != 0) {
            add2res(s, idx);
        }
        backTrace(s, idx + 1);
    }

    public void add2res(int s, int e) {
        for(int i = s; i <= e; i++) {
            res += arrTemp[i];
        }
    }

}