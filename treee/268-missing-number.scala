object Solution {
    def missingNumber(nums: Array[Int]): Int = {
        (nums ++ (0 to nums.length)).reduce(_^_)
    }
}
