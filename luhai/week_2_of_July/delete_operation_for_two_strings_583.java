class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] result = new int[l1 + 1][l2 + 1];
        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2;j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    result[i][j] = result[i - 1][j - 1] + 1;
                else
                    result[i][j] =Math.max(result[i][j - 1],result[i - 1][j]);

            }
        }
        return l1 + l2 - 2 * result[l1][l2];
    }
}