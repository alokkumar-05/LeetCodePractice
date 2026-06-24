class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = getMax(weights);
        int right = getSum(weights);
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(weights,mid,days)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
    private int getMax(int[] weights){
        int wei = 0;
        for(int w : weights){
            wei = Math.max(wei,w);
        }
        return wei;
    }
     private int getSum(int[] weights){
        int sum = 0;
        for(int w : weights){
            sum+=w;
        }
        return sum;
    }
    private boolean isValid(int[] weights , int mid , int days){
        int day = 1;
        int sum = 0;
        for(int w: weights){
           if(sum+w>mid){
              day++;
              sum=0;
           }
           sum+=w;

        }
        return day<=days;
    }
}