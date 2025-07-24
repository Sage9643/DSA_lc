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
    public int maxDepth(TreeNode root) {
        return Depth(root);
        
    }public static int Depth(TreeNode root){
        if(root==null){
            return 0;
        }int lheight=Depth(root.left);
        int rheight=Depth(root.right);

        return Math.max(lheight,rheight)+1;
    }
}