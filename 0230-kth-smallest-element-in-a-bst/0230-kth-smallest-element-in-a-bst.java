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
    static int el;
    static int cnt;
    public int kthSmallest(TreeNode root, int k) {
        el=0;cnt=0;
        dfs(root,k);

        return el;
    }
    public static void dfs(TreeNode root,int k){
        if(root==null) return;
        dfs(root.left,k);

        cnt++;
        if(cnt==k){
            el=root.val;
            return;
        }
        dfs(root.right,k);
    }

}