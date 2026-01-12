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
    
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=0;
        Queue<info> q=new LinkedList<>();
        q.add(new info(root,0));
        q.add(new info(null,-1));
        int minl=Integer.MAX_VALUE;
        int maxl=Integer.MIN_VALUE;

        while(!q.isEmpty()){
            info curr=q.remove();
            TreeNode node=curr.node;
            int idx=curr.idx;
            if(node!=null)minl=Math.min(idx,minl);
            if(node!=null)maxl=Math.max(idx,maxl);

            if(node==null){
                maxWidth=Math.max(maxl-minl+1,maxWidth);
                minl=Integer.MAX_VALUE;
                maxl=Integer.MIN_VALUE;
                
                if(!q.isEmpty()){
                    q.add(new info(null,-1));
                }else break;
            }else{
                if(node.left!=null) q.add(new info(node.left,2*idx+1));
                if(node.right!=null) q.add(new info(node.right,2*idx+2));
            }
        }return maxWidth;
                
    }
}class info{
    TreeNode node;
    int idx;
    info(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
}