package week1;

public class LeetCode0013 {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int res =0;
        char[] romanChars = s.toCharArray();

        for(int i=0; i<romanChars.length; i++){
               int num =1;
               if(romanChars[i] == 'I'){
                   num = 1;
                   if(i<=romanChars.length-2){
                       if(romanChars[i+1] == 'V'){
                           num = 4;
                           i++;
                       }else if(romanChars[i+1] == 'X'){
                           num = 9;
                           i++;
                       }
                   }
               }else if(romanChars[i] == 'V'){
                   num = 5;
               }else if(romanChars[i] == 'X'){
                    num = 10;
                   if(i<=romanChars.length-2){
                       if(romanChars[i+1] == 'L'){
                           num = 40;
                           i++;
                       }else if(romanChars[i+1] == 'C'){
                           num = 90;
                           i++;
                       }
                   }
               }else if(romanChars[i] == 'L'){
                   num = 50;
               }else if(romanChars[i] == 'C'){
                   num = 100;
                   if(i<=romanChars.length-2){
                       if(romanChars[i+1] == 'D'){
                           num = 400;
                           i++;
                       }else if(romanChars[i+1] == 'M'){
                           num = 900;
                           i++;
                       }
                   }
               }else if(romanChars[i] == 'D'){
                   num = 500;
               }else if(romanChars[i] == 'M'){
                   num = 1000;
               }
               res = res + num;
        }
        return res;
    }
}
