object Solution {
    def isPowerOfThree(n: Int): Boolean = {
        val epsilon = 0.00000000001
        return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
    }
}
