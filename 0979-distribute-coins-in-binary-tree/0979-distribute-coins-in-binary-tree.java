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
    static int moves;
    public int distributeCoins(TreeNode root) {
        moves=0;

        dfs(root);
        return moves;
    }
    public static int dfs(TreeNode root){
        if(root==null) return 0;

        int l=dfs(root.left);
        int r=dfs(root.right);

        moves+=Math.abs(l)+Math.abs(r);

        return l+r+root.val-1;

    }
}