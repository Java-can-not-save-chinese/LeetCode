class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length,n = B.length;
        if(n < m){ // 确保m <= n应对需要寻找的元素都在较长的数组中
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0,iMax = m, halfLen = (m + n + 1) / 2; //保证为奇数时多余的元素在左边
        while(iMin <= iMax){
            int i = iMin + (iMax - iMin) / 2;
            int j = halfLen - i;
            if(i < iMax && B[j - 1] > A[i]){
                iMin = i + 1;
            }else if(i > iMin && A[i - 1] > B[j]){
                iMax = i - 1;
            }else{
                int leftMax = 0;
                if(i == 0) leftMax = B[j - 1];
                else if(j == 0) leftMax = A[i - 1];
                else leftMax = Math.max(B[j - 1],A[i - 1]);
                if(m + n % 2 != 0) return leftMax;
                int rightMin = 0;
                if(i == m) rightMin = B[j];
                else if (j == n) rightMin = A[i];
                else rightMin = Math.max(B[j],A[i]);
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }
}