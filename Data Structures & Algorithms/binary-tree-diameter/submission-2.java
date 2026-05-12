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

    // Main function called by LeetCode
    public int diameterOfBinaryTree(TreeNode root) {

        // res[0] will store the maximum diameter found so far
        // Using an array so it can be updated inside recursive calls
        int[] res = new int[1];

        // Start DFS traversal
        dfs(root, res);

        // Diameter is stored in res[0]
        return res[0];
    }

    // DFS function returns the HEIGHT of the current subtree
    private int dfs(TreeNode root, int[] res) {

        // Base case: if node is null, height is 0
        if (root == null) return 0;

        // Recursively find height of left subtree
        int left = dfs(root.left, res);

        // Recursively find height of right subtree
        int right = dfs(root.right, res);

        // Diameter at current node = left height + right height
        // Update global maximum diameter
        res[0] = Math.max(res[0], left + right);

        // Return height of current subtree
        // Height = 1 (current node) + max(left, right)
        return 1 + Math.max(left, right);
    }
}
/*        1
       / \
      2   3
     / \
    4   5
/*
Step-by-step DFS traversal:

Start at root = 1

dfs(1):
    dfs(2):
        dfs(4):
            dfs(null) -> 0
            dfs(null) -> 0
            left = 0, right = 0
            res[0] = max(0, 0 + 0) = 0
            return 1   // height of node 4

        dfs(5):
            dfs(null) -> 0
            dfs(null) -> 0
            left = 0, right = 0
            res[0] = max(0, 0 + 0) = 0
            return 1   // height of node 5

        left = 1, right = 1
        res[0] = max(0, 1 + 1) = 2
        return 2       // height of node 2

    dfs(3):
        dfs(null) -> 0
        dfs(null) -> 0
        left = 0, right = 0
        res[0] = max(2, 0 + 0) = 2
        return 1       // height of node 3

    left = 2, right = 1
    res[0] = max(2, 2 + 1) = 3
    return 3           // height of node 1

Final Answer:
Diameter = res[0] = 3
(Path: 4 → 2 → 1 → 3)
*/
