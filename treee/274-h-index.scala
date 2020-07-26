object Solution {
    def hIndex(citations: Array[Int]): Int = {
        val sorted_citations = citations.sorted.reverse

        for (i <- (1 to sorted_citations.length).reverse) {
            if (sorted_citations(i - 1) >= i) {
                return i
            }
        }
        
        0
    }
}
