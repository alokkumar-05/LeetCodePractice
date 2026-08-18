class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int ans = helper(0, nums,dp);
        return ans;

    }

    private int helper(int idx, int[] arr,int[] dp) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }

        if (idx >= arr.length) {
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }

        int pick = arr[idx] + helper(idx + 2, arr,dp);
        int notPick = helper(idx + 1, arr,dp);

        return dp[idx]=Math.max(pick, notPick);
    }
}