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
    private int result = -1;
    private int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        traverse(root);
        return result;
    }

    private void traverse(TreeNode node) {
        if (node == null || result != -1) return;

        traverse(node.left);
        
        // Process current node
        count--;
        if (count == 0) {
            result = node.val;
            return;
        }

        traverse(node.right);
    }
}
