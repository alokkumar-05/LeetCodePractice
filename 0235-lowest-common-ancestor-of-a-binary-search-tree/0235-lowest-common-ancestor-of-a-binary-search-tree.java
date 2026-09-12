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

        List<TreeNode> h1= new ArrayList<>();
        List<TreeNode> h2= new ArrayList<>();

        helper(root,l1,p,h1);
        helper(root,l2,q,h2);

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
    private void helper(TreeNode root , List<TreeNode> list , TreeNode tar,List<TreeNode> h){
        if(root==null){
            return ;
        }
        h.add(root);
        if(root==tar){
           // list.clear();
            list.addAll(h);
            return;
        }
       
        helper(root.left,list,tar,h);
        helper(root.right,list,tar,h);
        h.remove(h.size()-1);

    }
}