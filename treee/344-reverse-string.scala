object Solution {
    def reverseString(s: Array[Char]): Unit = {
        var l: Int = 0
        var r: Int = s.length - 1
        
        while (l < r) {
            val t: Char = s(l)
            s(l) = s(r)
            s(r) = t
            l += 1
            r -= 1
        }
    }
}
