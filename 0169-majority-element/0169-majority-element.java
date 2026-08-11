class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0 ;
        int ele = Integer.MIN_VALUE;

        for(int num : nums){
            if(count ==0){
                ele= num;
            }
            if(num==ele){
                count++;
            }
            else{
                 count--;
            }
        }
        return ele;

    }
}