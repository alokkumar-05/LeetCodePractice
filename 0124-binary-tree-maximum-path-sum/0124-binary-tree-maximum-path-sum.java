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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};  // wrapper
        pathSum(root, max);
        return max[0];
        
    }
    private int pathSum(TreeNode root , int [] max ){
    
        if(root ==null){
            return 0;
        }
        int leftSum = Math.max(0,pathSum(root.left,max));
        int rightSum =Math.max(0,pathSum(root.right,max));

        max[0] = Math.max(max[0] , leftSum+rightSum+root.val);

        return Math.max(leftSum,rightSum)+root.val;

    }
}