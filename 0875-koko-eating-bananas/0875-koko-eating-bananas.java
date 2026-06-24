class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int left = 1  ;
        int right = getMax(piles);
        int ans = -1;

        while(left<=right){
            int mid = left +(right-left)/2;

            if(isValid(piles,mid,h)){
                ans = mid;
                right=mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }
    private int getMax(int[] piles){
        int max =-1;
        for(int p : piles){
            max = Math.max(p,max);;
        }
        return max;
    }

    private boolean isValid(int[] piles , int k , int h){
        long hr = 0 ;
        for(int p : piles){
            hr += ((long)p + k -1)/k;
        }
       return (hr <= h) ? true : false;
    }
}