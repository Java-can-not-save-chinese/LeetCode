object Solution {
    def restoreString(s: String, indices: Array[Int]): String = {
        val arr: Array[Char] = Array.ofDim(indices.length)
        for (i <- indices.indices) {
            arr(indices(i)) = s(i)
        }
        arr.mkString("")
    }
}
