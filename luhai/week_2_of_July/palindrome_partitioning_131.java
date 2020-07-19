class Solution {
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){return new ArrayList<>();}
        tracebacking(s,0,new ArrayList<>());
        return result;
    }

    List<List<String>> result = new ArrayList<>();

    public void tracebacking(String s,int start,List<String> list){
        if(start == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < s.length(); i++){
            String cur = s.substring(start,i + 1);
            if(isPalindrome(cur)){
                list.add(cur);
                tracebacking(s,i + 1,list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String cur){
        int start = 0, end = cur.length() - 1;
        while(start < end){
            if(cur.charAt(start) != cur.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}