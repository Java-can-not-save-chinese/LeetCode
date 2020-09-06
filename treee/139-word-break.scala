object Solution {
    def wordBreak(s: String, wordDict: List[String]): Boolean = {
        var vis: Map[String, Boolean] = Map()

        def wordBreakImpl(s: String): Boolean = {
            if (s.isEmpty) {
                true
            } else {
                if (vis.contains(s)) {
                    vis.get(s).get
                } else {
                    for (c <- wordDict if s.startsWith(c)) {
                        val res: Boolean = wordBreakImpl(s.substring(c.length))
                        vis += (s -> res)
                        if (res) {
                            return res
                        }
                    }
                    false
                }
            }
        }

        wordBreakImpl(s)
    }
}
