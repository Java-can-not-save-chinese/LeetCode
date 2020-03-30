package LeetCode.xinchengzhu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_Interview62 {

    public static void main(String[] args) {
        lastRemaining(5,3);
        // 0 1  3 4
    }


    public static int lastRemaining(int n, int m) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        int removeIndex = 0;
        while (list.size() != 1) {
            if(removeIndex>= list.size()){
                removeIndex = 0;
            }

            if(index == m-1){
                list.remove(removeIndex);
                index = 0;
                continue;
            }
            index++;
            removeIndex++;
        }

        return list.get(0);
    }
}
