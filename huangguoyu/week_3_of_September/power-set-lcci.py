class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.res = []
        self.res.append([])

        for i in range(len(nums)):
            temp = []
            temp.append(nums[i])
            self.res.append(temp)
            for j in range(i + 1, len(nums)):
                self.back_trace(j, nums, temp)
        return self.res


    def back_trace(self,idx, nums, route):
        if idx >= len(nums):
            return
        route.append(nums[idx])
        self.res.append(route[:])
        for i in range(idx + 1, len(nums)):
            self.back_trace(i, nums, route)
        route.pop()
        
