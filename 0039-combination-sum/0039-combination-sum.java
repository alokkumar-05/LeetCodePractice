class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ele = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        helper(candidates , 0 ,ele , res,  0 , target);
        return res;
    }

    private void helper(int[] candidates ,int start, List<Integer> ele , List<List<Integer>> res, int sum , int target){
        if(sum == target){
            res.add(new ArrayList<>(ele));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i= start; i<candidates.length ; i++){
            ele.add(candidates[i]);
            helper(candidates,i,ele,res,sum+candidates[i],target);
            ele.remove(ele.size()-1);
        }
    }
}