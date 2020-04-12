class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        ret = nums[0]
        for i in range(1, len(nums)):
            ret = ret ^ nums[i]
            
        return ret