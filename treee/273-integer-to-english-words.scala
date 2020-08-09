object Solution {
    def numberToWords(num: Int): String = {
        val mp = Map(
            1 -> "One",
            2 -> "Two",
            3 -> "Three",
            4 -> "Four",
            5 -> "Five",
            6 -> "Six",
            7 -> "Seven",
            8 -> "Eight",
            9 -> "Nine",
            10 -> "Ten",
            11 -> "Eleven",
            12 -> "Twelve",
            13 -> "Thirteen",
            14 -> "Fourteen",
            15 -> "Fifteen",
            16 -> "Sixteen",
            17 -> "Seventeen",
            18 -> "Eighteen",
            19 -> "Nineteen",
            20 -> "Twenty",
            30 -> "Thirty",
            40 -> "Forty",
            50 -> "Fifty",
            60 -> "Sixty",
            70 -> "Seventy",
            80 -> "Eighty",
            90 -> "Ninety"
        )

        val sz = List("", "Thousand", "Million", "Billion")

        def chunkNum(n: Int): List[Int] = {
            if (n == 0) {
                Nil
            } else {
                (n % 1000) +: chunkNum(n / 1000)
            }
        }

        val chunkedNum = chunkNum(num)

        val wordsList = chunkedNum.map(x => {
            var res: List[String] = List()
            if (x >= 100) {
                res = res :+ mp(x / 100)
                res = res :+ "Hundred"
            }
            if (x % 100 / 10 * 10 != 0) {
                if (x % 100 / 10 * 10 != 10) {
                    res = res :+ mp(x % 100 / 10 * 10)
                } else {
                    res = res :+ mp(x % 100)
                }
            }
            if (x % 10 != 0 && x % 100 / 10 * 10 != 10) {
                res = res :+ mp(x % 10)
            }
            res.mkString(" ")
        })


        val words = wordsList.zip(sz).map(x => {
            if (x._1 != "" && x._2 != "") {
                x._1 ++ " " ++ x._2
            } else {
                x._1
            }
        })

        if (words.isEmpty) {
            "Zero"
        } else {
            words.reverse.reduce((s, cur) => {
                if (cur != "") {
                    s ++ " " ++ cur
                } else {
                    s
                }
            })
        }
    }
}
