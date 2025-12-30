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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);q.add(null);

        int left=root.val;

        while(!q.isEmpty()){
            TreeNode curr=q.remove();

            if(curr!=null){
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }

            if(curr==null){
                if(q.isEmpty()) break;
                else{
                    left=q.peek().val;
                    q.add(null);
                }
            }
        }return left;
    }
}