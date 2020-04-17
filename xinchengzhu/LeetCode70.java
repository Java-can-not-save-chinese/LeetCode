package LeetCode.xinchengzhu;

public class LeetCode70 {


    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }

    public static int climbStairs(int n) {
        return climb_Stairs2(n);
    }

    private static int climb_Stairs1(int i, int n) {
        //递归方法
        if(i>n){
            return  0;
        }

        if(i == n){
            return 1;
        }
        return climb_Stairs1(i+1, n) + climb_Stairs1(i+2, n);
    }


    private static int climb_Stairs2(int n){
        //斐波那契
        /***
         * 0 1： 0的时候1种
         * 1 1： 1的时候1种
         * 2 2： 2的时候2种
         * 3 3： 3的时候3种
         * 4 5： 4的时候5种
         * 5 8： 5的时候8种
         */


        int[] stairs = new int[n+1];

        if( n <= 1){
            return  1;
        }


        stairs[0] = 1;
        stairs[1] = 1;
        stairs[2] = 2;

        for(int i=3; i<=n; i++){
            stairs[i] = stairs[i-1] + stairs[i-2];
        }

        return stairs[n];
    }
}
