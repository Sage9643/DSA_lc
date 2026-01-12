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
    static List<Integer> ans;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ans=new ArrayList<>();
        dfs(root1);dfs(root2);
        Collections.sort(ans);
        return ans;
    }
    public static void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}