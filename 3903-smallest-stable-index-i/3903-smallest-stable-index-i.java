class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minVal = new int[n];

        minVal[n-1]=nums[n-1];
        for(int i = n-2; i>=0 ; i--){
            minVal[i]= Math.min(nums[i], minVal[i+1]);
        }
        int maxVal= nums[0];

        int stable = -1;

        for(int i = 0; i<n;i++){
            maxVal = Math.max(maxVal , nums[i]);
            int iscore = maxVal-minVal[i];
            if(iscore<=k){
                return i;
            }
        }

        return stable;
        
    }
}