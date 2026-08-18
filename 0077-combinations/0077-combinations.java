class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ele = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        helper(n,1,ele,res,k);
        return res;
    }
    private void helper(int n , int start , List<Integer> ele ,  List<List<Integer>> res , int k){
        if(k==0){
            res.add(new ArrayList<>(ele));
            return;
        }
        for(int i = start ; i<=n;i++){
            ele.add(i);
            helper(n,i+1,ele,res,k-1);
            ele.remove(ele.size()-1);
        }
    }
}