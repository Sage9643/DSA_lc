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
    public int sumOfLeftLeaves(TreeNode root) {
        return sumleft(root,false);
    }
    public static int sumleft(TreeNode root,boolean left){
        if(root==null) return 0;
        if(left && root.right==null && root.left==null) return root.val;
        

        return sumleft(root.right,false)+sumleft(root.left,true);
    }
}