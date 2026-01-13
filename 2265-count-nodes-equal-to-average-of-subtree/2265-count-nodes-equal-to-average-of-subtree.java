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
    static int cnt;
    public int averageOfSubtree(TreeNode root) {
        cnt=0;
        dfs(root);
        return cnt;
    }
    public static info dfs(TreeNode root){
        if(root==null) return new info(0,0);
        info rt=dfs(root.right);
        info lt=dfs(root.left);

        if(((rt.sum+lt.sum+root.val)/(rt.freq+lt.freq+1))==root.val) cnt++;
        return new info(lt.sum+rt.sum+root.val,lt.freq+rt.freq+1);
    }

}class info{
    int sum;
    int freq;
    info(int sum,int freq){
        this.sum=sum;
        this.freq=freq;
    }
}