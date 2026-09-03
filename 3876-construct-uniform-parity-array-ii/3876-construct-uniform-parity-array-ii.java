class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean allEven = true;
        boolean allOdd = true;
        int min = Integer.MAX_VALUE;

        for(int num:nums1){
            if(num%2==0){
                allOdd = false;
            }
            else allEven = false;
            min = Math.min(num,min);
        }
        if(allEven||allOdd){
            return true;
        }
        if(min%2!=0){
            return true;
        }
        return false;
    }
}