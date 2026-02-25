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
    static ArrayList<String> ans;
    public String smallestFromLeaf(TreeNode root) {
        ans=new ArrayList<>();
        dfs(root,new StringBuilder());

        Collections.sort(ans);
        return ans.get(0);
        
    }public static void dfs(TreeNode root,StringBuilder sb){
        if(root==null) return;
        if(root.left==null && root.right==null){
            sb.append((char)('a'+root.val));
            StringBuilder sb1=new StringBuilder(sb);
            ans.add(new String(sb1.reverse()));
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        sb.append((char)('a'+root.val));
        dfs(root.left,sb);
        dfs(root.right,sb);
        sb.deleteCharAt(sb.length()-1);
    }
}