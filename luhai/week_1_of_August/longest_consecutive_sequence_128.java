class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,1);
        }
        int result = 0;
        for(Integer key:map.keySet()){
            int value = longest(map,key);
            map.put(key,value);
            result = Math.max(result,value);
        }
        return result;
    }
    public int longest(Map<Integer,Integer> map,Integer key){
        if(!map.containsKey(key)){
            return 0;
        }
        if(map.get(key) != 1){
            return map.get(key);
        }
        int value = map.get(key) +longest(map,key + 1);
        map.put(key,value);
        return value;
    }
}