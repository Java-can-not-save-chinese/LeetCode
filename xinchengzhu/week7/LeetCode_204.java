package LeetCode.xinchengzhu.week7;

public class LeetCode_204 {


    public int countPrimes(int n) {

        int count = 0;
        for(int i=2; i<n;i++){
            if(isPrime(i)){
                count++;
            }
        }

        return count;
    }



    Boolean isPrime(int n){
        if(n==2||n==3)	return true;
        if(n%6!=1&&n%6!=5)	return false;
        for(int i=5;i<= Math.floor(Math.sqrt(n));i+=6)
            if(n%i==0||n%(i+2)==0)
                return false;
        return true;
    }

}
