object Solution {
    def shuffle(nums: Array[Int], n: Int): Array[Int] = {
        val ret: Array[Int] = Array.ofDim(2 * n)
        for (i <- 0 until n) {
            ret(2 * i) = nums(i)
            ret(2 * i + 1) = nums(i + n)
        }
        ret
    }
}
