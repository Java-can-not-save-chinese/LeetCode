object Solution {
    def containsDuplicate(nums: Array[Int]): Boolean = {
        val mp = scala.collection.mutable.Map[Int, Int]()
        var ret: Boolean = false
        
        nums.foreach(i => {
            mp.get(i) match {
                case None => mp(i) = 1
                case _ => ret = true
            }
        })
        
        ret
    }
}