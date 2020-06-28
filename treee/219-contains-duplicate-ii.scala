object Solution {
    def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
        val mp = scala.collection.mutable.Map[Int, Int]()
        var ret: Boolean = false

        nums.zipWithIndex.foreach(item=> {
            mp.get(item._1) match {
                case None => mp(item._1) = item._2
                case x => if (item._2 - x.get > k) {
                    mp(item._1) = item._2
                } else {
                    ret = true
                }
            }
        })

        ret
    }
}