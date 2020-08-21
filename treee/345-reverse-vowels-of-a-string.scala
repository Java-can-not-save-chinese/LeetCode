object Solution {
    def reverseVowels(s: String): String = {
        val vowels: Set[Char] = Set('a', 'e', 'i', 'o', 'u')
        var l: Int = 0
        var r: Int = s.length - 1
        val arr: Array[Char] = s.toCharArray

        while (l < r) {
            while (l < r && !vowels.contains(s(l).toLower)) {
                l += 1
            }
            while (l < r && !vowels.contains(s(r).toLower)) {
                r -= 1
            }
            if (l < r) {
                val t: Char = s(l)
                arr(l) = arr(r)
                arr(r) = t
                l += 1
                r -= 1
            }
        }

        arr.mkString
    }
}
