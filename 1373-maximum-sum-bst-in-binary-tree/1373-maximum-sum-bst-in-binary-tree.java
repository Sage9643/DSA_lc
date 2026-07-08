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
    static int max;
    public int maxSumBST(TreeNode root) {
        max=0;

        dfs(root);
        return max;
    }
    public static info dfs(TreeNode root){
        if(root==null){
            return new info(0,Integer.MIN_VALUE,Integer.MAX_VALUE,true);
        }
        
        info left=dfs(root.left);
        info right=dfs(root.right);

        if(!left.valid || !right.valid){
            return new info(0,0,0,false);
        }
        if((left.max==Integer.MIN_VALUE && right.min==Integer.MAX_VALUE) || 
        (left.max==Integer.MIN_VALUE && root.val<right.min) || 
        (right.min==Integer.MAX_VALUE && root.val>left.max)|| (root.val<right.min && root.val>left.max)){

            long sum=root.val+left.sum+right.sum;
            max=(int)Math.max(max,sum);

            return new info(sum,Math.max(right.max,root.val),Math.min(root.val,left.min),true);

        }
        return new info(0,0,0,false);

    }
}class info{
    long sum;
    int max;
    int min;
    boolean valid;

    public info(long sum,int max,int min,boolean valid){
        
        this.sum=sum;
        this.max=max;
        this.min=min;
        this.valid=valid;
    }
}