# python range(a, b) => [a, b)
class Solution(object):
    def sumOddLengthSubarrays(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        self.res = 0
        self.arrTemp = arr
        for i in range(len(arr)):
            self.res += arr[i]
            self.back_trace(i, i + 1)

        return self.res;


    def back_trace(self, s, e):
        if (e >= len(self.arrTemp) or (e - s + 1) > len(self.arrTemp)):
            return
        if (((e - s + 1) % 2) != 0):
            self.add2res(s, e)
        
        self.back_trace(s, e + 1)


    def add2res(self, s, e):
        for i in range(s, e + 1):
            self.res += self.arrTemp[i]     
    