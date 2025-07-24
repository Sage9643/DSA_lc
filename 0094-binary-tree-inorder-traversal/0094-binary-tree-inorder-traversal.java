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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder=new ArrayList<>();
        Inorder(root,inorder);
        return inorder;
        
    }public static void Inorder(TreeNode root,List<Integer> inorder){
        if(root==null){
            return;
        }Inorder(root.left,inorder);
        inorder.add(root.val);
        Inorder(root.right,inorder);
    }
}