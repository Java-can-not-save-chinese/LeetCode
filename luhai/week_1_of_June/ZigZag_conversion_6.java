package week_1_of_June;

public class ZigZag_conversion_6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] builders = new StringBuilder[numRows];
        for(int i = 0 ; i < numRows; i++){
            builders[i] = new StringBuilder();
        }
        boolean is_add = true;
        int location = 0;
        for(int i = 0; i < s.length(); i++){
            if(is_add){
                builders[location++].append(s.charAt(i));
                if(location >= numRows){
                    location -= 2;
                    is_add = !is_add;
                }
            }else{
                builders[location--].append(s.charAt(i));
                if(location < 0){
                    location += 2;
                    is_add = !is_add;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder builder : builders){
            result.append(builder.toString());
        }
        return result.toString();
    }
}
