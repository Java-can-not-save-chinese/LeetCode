package week1;


import java.util.LinkedList;
import java.util.List;

public class LeetCode5727 {

    public static void main(String[] args) {
        System.out.println(findTheWinner(6,5));
    }

    public static int findTheWinner(int n, int k) {
        int[] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i]=i+1;
        }
        int count = 1;//循环计数
        int king = 0;//猴子大王的编号
        int index = 0;//数组的下标
        while(n!=0){
            if(index==nums.length) index=0;
            if(count==k && nums[index]!=0){
                nums[index]=0;
                n--;
                count++;
                if(count==k+1) count=1;
            }
            if(nums[index]!=0){
                count++;
                if(count==k+1) count=1;
            }
            index++;
        }
        king = index;
        return king;
    }
}
