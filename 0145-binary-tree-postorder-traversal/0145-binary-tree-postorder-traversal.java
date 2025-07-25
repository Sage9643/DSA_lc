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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> Postorder=new ArrayList<>();
        postorder(root,Postorder);
        return Postorder;
    }public static void postorder(TreeNode root,List<Integer> Postorder){
        if(root==null){
            return;
        }postorder(root.left,Postorder);
        postorder(root.right,Postorder);
        Postorder.add(root.val);
    }
}