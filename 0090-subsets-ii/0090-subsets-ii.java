class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        helper(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void helper(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        //"Pick" the current element
        current.add(nums[index]);
        helper(index + 1, nums, current, result);
        current.remove(current.size() - 1); // Backtrack

        // Skip all duplicate elements ahead so we don't pick an identical element at a later stage
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }
        
        // Move to the next distinct element
        helper(nextIndex, nums, current, result);
    }
}