class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d);
        String result = "";
        for(String element:d){
            int index = 0;
            for(int i = 0; i < s.length();i++){
                if(s.charAt(i)==element.charAt(index)){
                    index ++;
                }
                if(index == element.length()){
                    if(index > result.length()){
                        result = element;
                    }
                    break;
                }
            }
        }
        return result;
    }
}