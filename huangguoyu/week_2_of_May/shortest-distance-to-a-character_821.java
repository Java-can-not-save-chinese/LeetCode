class Solution {
    // O(n^2)
    public int[] shortestToChar(String S, char C) {
        Set<Integer> cIndx = new HashSet<>();
        for(int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                cIndx.add(i);
            }
        }

        int res[] = new int[S.length()];
        for(int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != C) {
                int min = S.length() + 1;
                for(Integer item : cIndx) {
                    item = Math.abs(item - i);
                    if (item < min) {
                        min = item;
                    }
                }
                res[i] = min;
            }
        }
        return res;
    }


    //O(n)
    public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}



