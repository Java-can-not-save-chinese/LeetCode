class Solution {
    public List<String> restoreIpAddresses(String s) {
        backTraceing(s,0,new ArrayList<>());
        return result;
    }

    List<String> result = new ArrayList<>();

    private void backTraceing(String s,int start,List<Integer> list){
        if(list.size() == 4){
            if(start == s.length()){
                StringBuilder builder = new StringBuilder();
                for(Integer element:list){
                    builder.append(element + ".");
                }
                builder.deleteCharAt(builder.length() - 1);
                result.add(builder.toString());
            }
            return;
        }
        for(int i = 1; i < 4;i++){
            int current = -1;
            try{
                current = Integer.valueOf(s.substring(start,start + i));
                if(i != bit(current)) return;
            }catch(Exception e){
                return;
            }

            if(0 <= current && current <= 255){
                list.add(current);
                backTraceing(s,start + i,list);
                list.remove(list.size() - 1);
            }else{
                return;
            }
        }
    }
    private int bit(int current){
        int count = 1;
        while(current / 10 != 0){
            count ++;
            current /= 10;
        }
        return count;
    }
}