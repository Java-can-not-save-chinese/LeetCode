object Solution {
    def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = {
        A.map(_.reverse).map(_.map(_ ^ 1))
    }
}
