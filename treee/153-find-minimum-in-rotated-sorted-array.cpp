class Solution {
public:
    int findMin(vector<int>& nums, int l, int r) {
        if (l == r)
            return nums[l];
        if (l + 1 == r)
            return min(nums[l], nums[r]);
        if (nums[l] < nums[r])
            return nums[l];
        
        return min(findMin(nums, l, (l + r) / 2), findMin(nums, (l + r) / 2, r));
    }
    
    int findMin(vector<int>& nums) {
        return findMin(nums, 0, nums.size() - 1);
    }
};