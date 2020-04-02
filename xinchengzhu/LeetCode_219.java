package LeetCode.xinchengzhu;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_219 {

    public static void main(String[] args) {
        int a[] = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(a, 2));

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>(nums.length);

      for(int i =0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k){
                //保证set集合中的个数不超过k个,也就是控制邻近距离
                set.remove( nums[i-k]);
            }
        }
        return false;
    }
}
