class NumArray(_nums: Array[Int]) {
    private val nums: Array[Int] = _nums
    private val sums: Array[Int] = _nums.scanLeft(0)(_ + _)

    def update(i: Int, `val`: Int): Unit = {
        val r = nums(i) - `val`
        nums(i) = `val`
        (i + 1 until sums.length).foreach(x => sums(x) = sums(x) - r)
    }

    def sumRange(i: Int, j: Int): Int = {
        sums(j + 1) - sums(i)
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * obj.update(i,`val`)
 * var param_2 = obj.sumRange(i,j)
 */
 