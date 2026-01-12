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
    static int sum;
    public int deepestLeavesSum(TreeNode root){
        sum=0;
        int height=heightOfTree(root);
        dfs(root,height,1);
        return sum;
    }
    public static void dfs(TreeNode root,int height,int currHeight){
        if(root==null) return;
        if(currHeight==height) {sum+=root.val;return;}

        dfs(root.left,height,currHeight+1);
        dfs(root.right,height,currHeight+1);
    }
    public static int heightOfTree(TreeNode root){
        if(root==null) return 0;
        int rh=heightOfTree(root.right);
        int lh=heightOfTree(root.left);

        return Math.max(rh,lh)+1;
    }
}