class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int smallest = nums[0];
        int largest = nums[n - 1];

        List<Integer> ans = new ArrayList<>();
        int k = 0;
        for (int i = smallest; i <= largest; i++) {
            if (k < n && nums[k] == i) {
                k++;
            } else {
                ans.add(i);
            }
        }
        return ans;

    }
}