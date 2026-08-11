class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int idx = nums.length/2;

        return nums[idx];
        
    }
}