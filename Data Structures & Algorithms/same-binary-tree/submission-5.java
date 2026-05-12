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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: both nodes are null
        // Trees match up to this point
        if(p==null && q== null)return true;
        // Case 2: both nodes are non-null AND values match
        // Recursively check left and right subtrees
        if(p!=null && q != null && p.val==q.val){
            return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);
        }
        // Case 3: one node is null OR values do not match
        // Trees are not the same
        return false;
    }
}
