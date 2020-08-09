object Solution {
    def maxProduct(words: Array[String]): Int = {
        if (words.length == 0) {
            return 0
        }
        
        val wordsCnt: Array[(Int, Int)] = words.map(word =>
            (word.length, word.foldRight(0)((x, acc) => acc | (1 << (x - 'a')))))

        wordsCnt.map(a => wordsCnt.map(b => {
            if ((a._2 & b._2) == 0) {
                a._1 * b._1
            } else {
                0
            }
        }).max).max
    }
}
