object Solution {
    def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        val a1: Array[Int] = nums1.sorted
        val a2: Array[Int] = nums2.sorted
        var ret: Array[Int] = Array()

        var l: Int = 0
        var r: Int = 0

        while (l < a1.length && r < a2.length) {
            while (l < a1.length && a1(l) < a2(r)) {
                l += 1
            }
            while (l < a1.length && r < a2.length && a1(l) > a2(r)) {
                r += 1
            }
            if (l < a1.length && r < a2.length && a1(l) == a2(r)) {
                ret = ret :+ a1(l)
                l += 1
                r += 1
            }
        }

        ret
    }
}
