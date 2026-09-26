class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        //Find breakpoint
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                idx = i - 1;
                break;
            }
        }

        //If no breakpoint then reverse whole array
        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        //Find just greater element from right
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }

        // Reverse the suffix
        reverse(nums, idx + 1, n - 1);
    }

    //method to swap
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //method to reverse
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}