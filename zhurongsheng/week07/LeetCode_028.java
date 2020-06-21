package week07;

public class LeetCode_028 {


    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int index = -1;
        int startIndex = 0;
        int x;
        for(int i=0; i<haystack.length(); i++){
            x = 0;
            for(int j=0; j<needle.length(); j++){
                if((i+x) >= haystack.length()){
                    return -1;
                }else{
                    if(needle.charAt(j) == haystack.charAt(i+x)){
                        if(j == 0){
                            startIndex = i;
                        }
                        x++;
                    }else{
                        break;
                    }
                }
            }

            if(x == needle.length()){
                index = startIndex;
                break;
            }
            //i = i+x;
        }
        return index;
    }
}
