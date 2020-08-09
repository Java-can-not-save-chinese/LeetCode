object Solution {
    def isUgly(num: Int): Boolean = {
        if (num <= 0) {
            false
        } else if (num == 1) {
            true
        } else if (num % 2 == 0) {
            isUgly(num / 2)
        } else if (num % 3 == 0) {
            isUgly(num / 3)
        } else if (num % 5 == 0) {
            isUgly(num / 5)
        } else {
            false
        }
    }
}
