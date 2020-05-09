

/**
    用hash记录遍历过的数
    还可以利用hash直接记录第一次遍历的 余数-> 数量 
*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        return graceful(time);
    }


    public int graceful(int[] data) {
        int res = 0;
        Map<Integer, Integer> temp = new HashMap<>();
        temp.put(data[0], 1);
        int max = data[0], min = data[0];
        for(int i = 1; i < data.length; i++) {
            int start;
            if(data[i] % 60 == 0) {
                start = 60;
            } else {
                start = 60 - data[i] % 60;
            }
            int index = 0;
            while(start <= max) {
                if (temp.get(start) != null) {
                    res += temp.get(start);
                } 
                index++;
                start = (60 - data[i] % 60) + 60 * index;
            }
            temp.put(data[i], temp.get(data[i]) == null ? 1 : temp.get(data[i]) + 1);
            if (data[i] > max) max = data[i];
        }
        return res;
    }

    public int force(int[] data) {
        int res = 0;
        for(int i = 0; i < data.length; i++) {
            for(int j = i + 1; j < data.length; j++) {
                if ((data[i] + data[j]) % 60 == 0) res++;
            }
        }
        return res;
    }
}