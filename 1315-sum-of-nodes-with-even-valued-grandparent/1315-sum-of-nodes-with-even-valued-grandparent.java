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
    public int sumEvenGrandparent(TreeNode root) {
        sum=0;
        dfs(root);
        return sum;
    }
    public static void dfs(TreeNode root){
        if(root==null ||(root.left==null && root.right==null)) return;
        if(root.val%2==0){
            if(root.right!=null){
                if(root.right.right!=null) sum+=root.right.right.val;
            }if(root.left!=null){
                if(root.left.left!=null) sum+=root.left.left.val;
            }if(root.right!=null){
                if(root.right.left!=null) sum+=root.right.left.val;
            }if(root.left!=null){
                if(root.left.right!=null) sum+=root.left.right.val;
            }
        }dfs(root.left);
        dfs(root.right);
    }
}