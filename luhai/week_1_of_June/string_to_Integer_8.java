class Solution {
    public int myAtoi(String str) {
        if(str.equals("")) return 0;

        long result = myAtoi(str,0,0,false);

        return  result < Integer.MIN_VALUE ? Integer.MIN_VALUE : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }
    public long myAtoi(String str,long current,int positive,boolean flag){
        if("".equals(str)){
            return positive == -1 ?current * positive : current;
        }
        char first = str.charAt(0);
        if(' '== first){
            return !flag  ? myAtoi(str.substring(1),current,positive,flag) : positive == -1 ?current * positive : current;
        }
        if(first == '-' || first == '+'){

            if(current != 0 || positive != 0 || flag ){
                return positive == -1 ?current * positive : current;
            }
            flag = true;
            positive = first == '-' ? -1 : 1;
            return myAtoi(str.substring(1),current,positive,flag);
        }

        if(first >= '0'&& first <= '9'){
            current = (current * 10 + (first - '0')) ;
            if(current > Integer.MAX_VALUE && positive != -1){
                return Integer.MAX_VALUE;
            }
            if(positive == -1 && current * positive < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            flag = true;
            return myAtoi(str.substring(1),current,positive,flag);
        }else{
            if(current == 0){
                return 0;
            }
            return  positive == -1 ?current * positive : current;
        }
    }
}