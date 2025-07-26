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
class Info{
    int diam;
    int ht;
    public Info(int diam,int ht){
        this.diam=diam;
        this.ht=ht;
    }
}
class Solution {
    public int diameterOfBinaryTree(TreeNode root){
        if(root==null){
            return 0;
        }
        Info data=diameter(root);
        return data.diam;
    }
    public static Info diameter(TreeNode root){
        if(root==null){
            return new Info(0,0);
        }Info left=diameter(root.left);
        Info right=diameter(root.right);

        int diam=Math.max(Math.max(left.diam,right.diam),left.ht+right.ht);
        int ht=Math.max(left.ht,right.ht)+1;

        return new Info(diam,ht);
    }
}