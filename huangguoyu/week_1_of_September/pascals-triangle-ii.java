class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        if (rowIndex == 0) return temp;
        if (rowIndex == 1) {
            temp.add(1);
            return temp;
        }
        temp.add(1);

        List<Integer> res = new ArrayList<>();
        for(int i = 2; i <= rowIndex; i++) {
            for(int j = 0; j <= i; j++) {
                if (j == 0) {
                    res.add(1);
                    continue;
                }
                if (j == i) {
                    res.add(1);
                    continue;
                }
                res.add(temp.get(j - 1) + temp.get(j));
            }
            temp = res;
            if (i != rowIndex)
                res = new ArrayList<>();
        }
        return res;
    }
}