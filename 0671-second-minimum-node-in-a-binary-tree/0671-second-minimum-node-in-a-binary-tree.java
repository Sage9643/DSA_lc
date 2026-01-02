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
    public int findSecondMinimumValue(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        dfs(root,ans);
        Collections.sort(ans);
        int min=ans.get(0);
        for(int a:ans){
            if(a>min){min=a;break;}
        }if(min==ans.get(0)) return -1;
        return min;
    }
    public static void dfs(TreeNode root,ArrayList<Integer> ans){
        if(root==null) return;
        ans.add(root.val);
        dfs(root.left,ans);
        dfs(root.right,ans);
    }
}