class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];//返回的结果
        int numsSum = 0;//数组和
        Set set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                //把重复的数保存
                result[0] = num;
            }
            numsSum += num;
        }
        //完成的1至n的和
        int sum = (1 + nums.length) * nums.length / 2;
        int c = sum - numsSum;//差值
        result[1] = result[0] + c;//缺失的数
        return result;
    }
}