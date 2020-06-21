package week09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/5/25 19:53
 */
public class Leetcode_1282 {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                List<Integer> list = new ArrayList<>();
                map.put(groupSizes[i], list);
            }
            List<Integer> list = map.get(groupSizes[i]);
            list.add(i);
            if (list.size() == groupSizes[i]) {
                result.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return result;
    }

}
