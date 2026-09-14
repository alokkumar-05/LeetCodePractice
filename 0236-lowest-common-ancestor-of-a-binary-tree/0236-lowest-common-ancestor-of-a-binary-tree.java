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
        if (root == null) {
            return null;
        }
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        path(root,l1,p);
        path(root,l2,q);

        int n = Math.min(l1.size(),l2.size());

        TreeNode res= null;

        for(int i = 0 ; i<n ; i++){
            if(l1.get(i)==l2.get(i)){
                res = l1.get(i);
            }
            else break;
        }
        return res;
    }

    private boolean path(TreeNode root, List<TreeNode> list, TreeNode tar) {
        if (root == null) {
            return false;
        }

        list.add(root);
        if (root == tar) {
            return true;
        }
        boolean left = path(root.left, list, tar);
        boolean right = path(root.right, list, tar);

        if (left || right) {
            return true;
        }
        list.remove(list.size()-1);
        return false;

    }
}