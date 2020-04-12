class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        num1 = num2 = cnt1 = cnt2 = 0
        
        for item in nums:
            if num1 == item:
                cnt1 += 1
            elif num2 == item:
                cnt2 += 1
            elif cnt1 == 0:
                num1 = item
                cnt1 += 1
            elif cnt2 == 0:
                num2 = item
                cnt2 += 1
            else:
                cnt1 -= 1
                cnt2 -= 1
                
        cnt1 = cnt2 = 0
        for item in nums:
            if num1 == item:
                cnt1 += 1
            elif num2 == item:
                cnt2 += 1
        
        ret = []
        l = len(nums)
        if cnt1 > l // 3:
            ret.append(num1)
        if cnt2 > l // 3:
            ret.append(num2)
            
        return ret

# Runtime: 128 ms, faster than 31.83% of Python3 online submissions for Majority Element II.
# Memory Usage: 15.1 MB, less than 5.88% of Python3 online submissions for Majority Element II.