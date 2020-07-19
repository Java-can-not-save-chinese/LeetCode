class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for(int i = 0; i < numbers.length; i++) {
            Integer temp = map.get(target - numbers[i]);
            if (temp != null && temp > i) {
                return new int[]{i + 1, temp + 1};
            }
        }
        return new int[]{0,0};
    }
}