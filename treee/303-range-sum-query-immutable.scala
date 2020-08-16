class NumArray(_nums: Array[Int]) {
    private val nums: Array[Int] = _nums.scanLeft(0)(_ + _)

    def sumRange(i: Int, j: Int): Int = {
        nums(j + 1) - nums(i)
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */
 