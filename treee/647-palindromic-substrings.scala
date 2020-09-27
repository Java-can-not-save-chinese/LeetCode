object Solution {
    def countSubstrings(s: String): Int = {
        def isPalindromic(l: Int, r: Int): Boolean = {
            if (l >= r) {
                true
            } else {
                if (s(l) == s(r)) {
                    isPalindromic(l + 1, r - 1)
                } else {
                    false
                }
            }
        }

        var cnt: Int = 0
        for (i <- 0 until s.length) {
            for (j <- i until s.length) {
                if (isPalindromic(i, j)) {
                    cnt += 1
                }
            }
        }
        
        cnt
    }
}
