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

    // Main function: returns true if tree is height-balanced
    public boolean isBalanced(TreeNode root) {

        // dfs(root)[0] returns:
        // 1 -> balanced
        // 0 -> not balanced
        return dfs(root)[0] == 1;
    }

    // DFS returns an int array of size 2:
    // index 0 -> whether subtree is balanced (1 = yes, 0 = no)
    // index 1 -> height of subtree
    private int[] dfs(TreeNode root) {

        // Base case: empty tree is balanced with height 0
        if (root == null) {
            return new int[]{1, 0};
        }

        // Get results from left subtree
        int[] left = dfs(root.left);

        // Get results from right subtree
        int[] right = dfs(root.right);

        // Check if:
        // 1. Left subtree is balanced
        // 2. Right subtree is balanced
        // 3. Height difference is at most 1
        boolean balanced =
                (left[0] == 1 && right[0] == 1) &&
                (Math.abs(left[1] - right[1]) <= 1);

        // Height of current node
        int height = 1 + Math.max(left[1], right[1]);

        // Return:
        // balanced -> 1 or 0
        // height   -> computed height
        return new int[]{balanced ? 1 : 0, height};
    }
}

