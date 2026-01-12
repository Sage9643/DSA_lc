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
    static int cnt;
    public int goodNodes(TreeNode root) {
        cnt=0;
        int max=Integer.MIN_VALUE;
        dfs(root,max);
        return cnt;
    }
    public static void dfs(TreeNode root,int max){
        if(root==null) return;

        if(root.val>=max) cnt++;
        max=Math.max(max,root.val);
        dfs(root.left,max);
        dfs(root.right,max);
    }
}