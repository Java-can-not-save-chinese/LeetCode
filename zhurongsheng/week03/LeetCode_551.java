package week02;

/**
 * @Description:
 * @Auther: zhurongsheng
 * @Date: 2020/4/19 22:28
 */
public class LeetCode_551 {

    public boolean checkRecord(String s) {
        int count=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='A')
                count++;
        return count<2 && s.indexOf("LLL")<0;
    }
}
