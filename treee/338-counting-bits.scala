object Solution {
    def countBits(num: Int): Array[Int] = {
        val ret: Array[Int] = Array.ofDim(num + 1)
        if (num == 0) {
            return ret
        }

        var base: Int = 0
        var upper: Long = 1
        for (i <- 1 to num) {
            if (i >= upper) {
                ret(i) = 1
                base = upper.toInt
                upper = upper * 2
            } else {
                ret(i) = ret(base) + ret(i - base)
            }
        }

        ret
    }
}
