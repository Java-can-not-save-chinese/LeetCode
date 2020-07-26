// Memory Limit Exceeded

object Solution {
    def calculate(s: String): Int = {
        import scala.collection.mutable.ListBuffer
        def next(s: String): Option[(Either[Int, Char], String)] = {
            if (s.isEmpty) {
                None
            } else if (Character.isSpaceChar(s.head)) {
                next(s.tail)
            } else if (Character.isDigit(s.head)) {
                var t = ""
                var s1 = s
                while (!s1.isEmpty && Character.isDigit(s1.head)) {
                    t = t :+ s1.head
                    s1 = s1.tail
                }
                Some(Left(Integer.parseInt(t)), s1)
            } else {
                Some(Right(s.head), s.tail)
            }
        }

        def iterNonRec(s: String): ListBuffer[Either[Int, Char]] = {
            var l = ListBuffer[Either[Int, Char]]()
            var res = next(s)
            while (res.isDefined) {
                val q = res.get._2
                l = l :+ res.get._1
                res = next(q)
            }
            l
        }

        def iter(s: String): Seq[Either[Int, Char]] = {
            next(s) match {
                case None => Nil
                case Some((t, q)) => {
                    t +: iter(q)
                }
            }
        }

        def calcOne(a: Int, b: Int, op: Char): Int = {
            op match {
                case '+' => a + b
                case '-' => b - a
            }
        }

        def calc(seq: ListBuffer[Either[Int, Char]], stkNum: Seq[Int], stkOp: Seq[Char]): Int = {
            if (seq.isEmpty) {
                if (stkNum.isEmpty) {
                    0
                } else {
                    stkNum.head
                }
            } else {
                seq.head match {
                    case Left(n) => {
                        if (stkOp.isEmpty || stkOp.head == '(') {
                            calc(seq.tail, n +: stkNum, stkOp)
                        } else {
                            val r = calcOne(n, stkNum.head, stkOp.head)
                            calc(seq.tail, r +: stkNum.tail, stkOp.tail)
                        }
                    }
                    case Right(op) => {
                        if (op == ')') {
                            if (!stkOp.tail.isEmpty) {
                                val r = calcOne(stkNum.head, stkNum.tail.head, stkOp.tail.head)
                                calc(seq.tail, r +: stkNum.tail.tail, stkOp.tail.tail)
                            } else {
                                calc(seq.tail, stkNum, stkOp.tail)
                            }
                        } else {
                            calc(seq.tail, stkNum, op +: stkOp)
                        }
                    }
                }
            }
        }

        calc(iterNonRec(s), Seq(), Seq())
    }
}
