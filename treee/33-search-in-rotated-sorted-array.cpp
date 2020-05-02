class Solution {
public:
    int search(vector<int>& nums, int l, int r, int target) {
        if (l > r)
            return -1;
        if (nums[l] == target)
            return l;
        if (nums[r] == target)
            return r;
        if (l == r)
            return nums[l] == target ? l : -1;
        int m = (l + r) / 2;
        if (nums[m] == target)
            return m;
        if (nums[0] < nums[m] && target >= nums[0] && target < nums[m])
            return search(nums, 0, m - 1, target);
        if (nums[0] > nums[m] && (target < nums[m] || target >= nums[0]))
            return search(nums, 0, m - 1, target);
        if (nums[m] < nums[r] && target > nums[m] && target <= nums[r])
            return search(nums, m + 1, r, target);
        if (nums[m] > nums[r] && (target <= nums[r] || target > nums[m]))
            return search(nums, m + 1, r, target);
        return -1;
    }
    
    int search(vector<int>& nums, int target) {
        return search(nums, 0, nums.size() - 1, target);
    }
};