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
    static int cameras;
    public int minCameraCover(TreeNode root) {
        cameras=0;
        if(root.left==null && root.right==null) return 1;

        int state=dfs(root);
        if(state==-1) cameras++;
        return cameras;

    }
    public static int dfs(TreeNode root){
        if(root==null) return 0;
        int l=dfs(root.left);
        int r=dfs(root.right);

        if(l==0 && r==0) return -1;
        else if(l==-1 || r==-1){
            cameras+=1;
            return 1;
        }
        return  0;
    }
}