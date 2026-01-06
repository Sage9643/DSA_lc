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
    public int maxLevelSum(TreeNode root) {
        int sum=0;int level=0;int maxsum=Integer.MIN_VALUE;int minlevel=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);q.add(null);

        while(!q.isEmpty()){
            TreeNode curr=q.remove();

            if(curr==null){
                level++;
                if(maxsum<sum){
                    maxsum=sum;
                    minlevel=level;
                }sum=0;
                if(q.isEmpty()) break;
                else q.add(null);
            }else{
                sum+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }return minlevel;
    }
}