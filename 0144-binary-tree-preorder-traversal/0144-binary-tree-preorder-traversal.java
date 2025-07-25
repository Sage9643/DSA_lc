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
    static 
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> Preorder=new ArrayList<>();
        preorder(root,Preorder);
        return Preorder;

    }public static void preorder(TreeNode root,List<Integer> Preorder){
        if(root==null){
            return ;
        }Preorder.add(root.val);
        preorder(root.left,Preorder);
        preorder(root.right,Preorder);
    }
}