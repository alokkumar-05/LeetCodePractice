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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
       return helper(root,0,targetSum);
        
    }
    private boolean helper(TreeNode root, int csum , int tar){
         if(root == null){
            return false;
        }

        csum += root.val;
        tar -= root.val;

        // Check only at leaf
        if(root.left == null && root.right == null){
            return tar == 0;
        }

        boolean l = helper(root.left, csum, tar);
        boolean r = helper(root.right, csum, tar);

        return l || r;
    }
}