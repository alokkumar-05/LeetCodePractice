/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ele = new ArrayList<>();

        if(root==null){
            return res;
        }

        sum(root,targetSum , ele , res);
        return res;
        
    }
    private void sum(TreeNode root , int tar ,List<Integer> ele , List<List<Integer>> res){
        if(root==null){
            return ;
        }
        tar = tar - root.val;
        ele.add(root.val);
        if(root.left==null && root.right==null){
            if(tar==0){
                res.add(new ArrayList<>(ele));
            }
            ele.remove(ele.size() - 1);
            return ;
        }
        sum(root.left, tar ,ele , res );
        sum(root.right , tar , ele , res);
        ele.remove(ele.size()-1);
    }
}