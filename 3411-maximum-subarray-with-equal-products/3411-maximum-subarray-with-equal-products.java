class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int mlen = 1;
        

        for(int l= 0 ; l<n ;l++){
            long pro = 1;
            long gcd = 0;
            long lcm = 1;
            for(int r = l ; r<n;r++){
                pro = pro*nums[r];
                gcd = hcf(gcd,nums[r]);
                lcm = (lcm/hcf(lcm,nums[r]))*nums[r];

                if(pro==(gcd*lcm)){
                    mlen = Math.max(mlen,r-l+1);
                }

            }
            
        }
        return mlen;
    }
    private long hcf(long a , long b){
        if(b==0){
            return a;
        }
        return hcf(b,a%b);
    }
}