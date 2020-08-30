object Solution {
    def integerBreak(n: Int): Int = {
        if (n < 4) {
            return n - 1
        }
        
        var ret: Int = 1
        var t: Int = n

        while (t > 4) {
            ret *= 3
            t -= 3
        }

        ret * t
    }
}
