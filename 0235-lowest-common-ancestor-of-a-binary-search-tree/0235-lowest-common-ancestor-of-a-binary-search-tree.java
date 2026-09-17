/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1= new ArrayList<>();
        List<TreeNode> l2= new ArrayList<>();

        helper(root,l1,p);
        helper(root,l2,q);

        TreeNode ans = null;
        int n = Math.min(l1.size(), l2.size());
        for(int i=0 ; i<n;i++){
            if(l1.get(i)==l2.get(i)){
               ans=l1.get(i);
            }
            else{
                break;
            }
        }
        return ans;
    }
    private boolean  helper(TreeNode root , List<TreeNode> list, TreeNode tar){
        if(root==null){
            return false;
        }
        list.add(root);
        if(root==tar){
            return true;
        }
        boolean left = helper(root.left, list , tar);
        boolean right = helper(root.right, list , tar);

        if(left || right){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
}