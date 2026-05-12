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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // An empty tree is always a subtree
        if(subRoot==null)return true;
        // If main tree is empty but subRoot is not, impossible
        if(root == null)return false;
        // If trees match starting at current node
        if(sameTree(root,subRoot))return true;
        // Otherwise, try left and right subtrees
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    //checks if two trees are exactly the same
    public boolean sameTree(TreeNode root, TreeNode subRoot){
        // Both nodes are null -> trees match here
        if(root==null && subRoot==null)return true;
        // Both non-null and values match
        if(root != null && subRoot != null && root.val==subRoot.val){
            // Recursively compare left and right subtrees
            return sameTree(root.left, subRoot.left)
            && sameTree(root.right, subRoot.right);
        }
         // One is null or values differ -> not same
        return false;
    }
}
