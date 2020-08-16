object Solution {
    def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
        nums.zipWithIndex.groupBy(_._1).toList.sortBy(_._2.length).reverse.map(_._1).take(k).toArray
    }
}
