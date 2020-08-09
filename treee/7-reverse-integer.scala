object Solution {
    def reverse(x: Int): Int = {
        val carry = if (x > 0) {
            1
        } else {
            -1
        }

        var t = Math.abs(x)
        var r = 0
        while (t != 0) {
            val n = r * 10
            if ((n / 10) != r) {
                return 0
            }
            r = n + (t % 10)
            t /= 10
        }

        r * carry
    }
}
