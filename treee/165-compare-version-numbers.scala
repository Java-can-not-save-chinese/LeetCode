object Solution {
    def compareVersion(version1: String, version2: String): Int = {
        def parse(version: String): List[Int] = {
            version.split("[.]").map(_.toInt).toList
        }

        val l1 = parse(version1)
        val l2 = parse(version2)

        def compare(l1: List[Int], l2: List[Int]): Int = {
            if (l1.isEmpty && l2.isEmpty) {
                0
            } else if (l1.isEmpty) {
                if (l2.head != 0) {
                    -1
                } else {
                    compare(l1, l2.tail)
                }
            } else if (l2.isEmpty) {
                if (l1.head != 0) {
                    1
                } else {
                    compare(l1.tail, l2)
                }
            } else {
                if (l1.head == l2.head) {
                    compare(l1.tail, l2.tail)
                } else if (l1.head > l2.head) {
                    1
                } else {
                    -1
                }
            }
        }

        compare(l1, l2)
    }
}
