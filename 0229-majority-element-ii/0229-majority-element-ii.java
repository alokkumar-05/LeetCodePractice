class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityElements = new ArrayList<>();
        int n = nums.length;
        
        // Count frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Add elements whose count > floor(n/3)
        for (Integer key : map.keySet()) {
            if (map.get(key) > n / 3) {
                majorityElements.add(key);
            }
        }   

        return majorityElements;
    }
}