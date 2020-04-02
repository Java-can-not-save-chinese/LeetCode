package LeetCode.xinchengzhu;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_217 {

    public static void main(String[] args) {
        int a[] = {1,1,2,3,4};
        System.out.println(containsDuplicate(a));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);

        for(int num : nums){
            set.add(num);
        }
        return !(set.size() == nums.length);
    }
}
