object Solution {
    def generateParenthesis(n: Int): List[String] = {
        def gen(l: Int, r: Int): List[String] = {
            if (l == 0 && r == 0) {
                List("")
            } else if (l == 0) {
                val res = gen(l, r - 1)
                res.map(x => ")" ++ x)
            } else if (l < r) {
                val r1 = gen(l - 1, r)
                val r2 = gen(l, r - 1)

                r1.map(x => '(' +: x) ++ r2.map(x => ')' +: x)
            } else {
                val r1 = gen(l - 1, r)
                r1.map(x => '(' +: x)
            }
        }

        gen(n, n)
    }
}
