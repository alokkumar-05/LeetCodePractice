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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int pathMax) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        // Check if the current node is a good node
        if (node.val >= pathMax) {
            count = 1;
            pathMax = node.val; // Update max for children
        }
        count += dfs(node.left, pathMax);
        count += dfs(node.right, pathMax);

        return count;
    }
}