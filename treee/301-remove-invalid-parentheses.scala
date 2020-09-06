object Solution {
    def removeInvalidParentheses(s: String): List[String] = {
        def isValidParentheses(s: String): Boolean = {
            if (s.isEmpty) {
                true
            } else {
                var l: Int = 0
                for (c <- s) {
                    c match {
                        case '(' => l += 1
                        case ')' => l -= 1
                        case _ =>
                    }
                    if (l < 0) {
                        return false
                    }
                }
                l == 0
            }
        }

        var que: List[String] = List(s)
        var visited: Set[String] = Set()

        while (!que.isEmpty) {
            val cur: String = que.head
            que = que.tail

            if (isValidParentheses(cur)) {
                return List(cur) ++ que.filter(isValidParentheses)
            }

            for (i <- 0 until cur.length) {
                if (cur(i) == '(' || cur(i) == ')') {
                    val newString: String = cur.substring(0, i) + cur.substring(i + 1)
                    if (!visited.contains(newString)) {
                        visited += newString
                        que :+= newString
                    }
                }
            }
        }

        List("")
    }
}
