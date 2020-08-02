object Solution {
    def wordPattern(pattern: String, str: String): Boolean = {
        var mp1 = Map[Char, String]()
        var mp2 = Map[String, Char]()
        val words = str.split(" ")

        if (words.size != pattern.length) {
            return false
        }

        for (i <- 0 until words.length) {
            if (!mp1.contains(pattern(i)) && !mp2.contains(words(i))) {
                mp1 += (pattern(i) -> words(i))
                mp2 += (words(i) -> pattern(i))
            } else if (mp1.contains(pattern(i))) {
                if (!mp2.contains(words(i)) || mp2(words(i)) != pattern(i)) {
                    return false
                }
            } else if (mp2.contains(words(i))) {
                if (!mp1.contains(pattern(i)) || mp1(pattern(i)) != words(i)) {
                    return false
                }
            } else if (mp1(pattern(i)) != words(i) || mp2(words(i)) != pattern(i)) {
                return false
            }
        }

        true
    }
}
