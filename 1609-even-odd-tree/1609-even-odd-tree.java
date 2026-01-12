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
    public boolean isEvenOddTree(TreeNode root){
        int level=0;
        Queue<TreeNode> q=new LinkedList<>();
        if(root.val%2==0) return false;
        q.add(root);
        q.add(null);
        int val=Integer.MIN_VALUE;

        while(!q.isEmpty()){
            TreeNode curr=q.remove();

            if(curr==null){
                if(q.isEmpty()) break;
                else{
                    q.add(null);
                    val=level%2==0?Integer.MAX_VALUE:Integer.MIN_VALUE;
                    level++;
                }
            }else{
                if(level%2==0){
                    if(curr.val<=val) return false;
                    if(curr.left!=null){
                        if(curr.left.val%2!=0) return false;
                    }if(curr.right!=null){
                        if(curr.right.val%2!=0) return false;
                    }
                }else{
                    if(curr.val>=val) return false;
                    if(curr.left!=null){
                        if(curr.left.val%2==0) return false;
                    }if(curr.right!=null){
                        if(curr.right.val%2==0) return false;
                    }
                }if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);

                val=curr.val;
            }
        }return true;
        
    }
}