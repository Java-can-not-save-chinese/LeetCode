package week07;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_217 {



    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);

        for(int num : nums){
            set.add(num);
        }
        return !(set.size() == nums.length);
    }
}
