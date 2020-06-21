class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        StringBuilder result = new StringBuilder();
        int min_length = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() < min_length){
                min_length = strs[i].length();
            }
        }
        int index = 0;
        flag:
        while(index < min_length){
            char one = strs[0].charAt(index);
            int location = 1;
            while(location < strs.length){
                if(one != strs[location].charAt(index)){
                    break flag;
                }
                location ++;
            }
            result.append(one);
            index ++;
        }
        return result.toString();
    }
}