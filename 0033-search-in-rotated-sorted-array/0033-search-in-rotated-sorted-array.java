class Solution {
    public int search(int[] nums, int target) {
        return src(nums, target, 0, nums.length - 1);
    }

    private int src(int[] nums, int target, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[s] <= nums[mid]) {
                if (nums[s] <= target && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } 
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
}
