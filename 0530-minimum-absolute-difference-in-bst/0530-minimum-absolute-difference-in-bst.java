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
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        dfs(root,arr);
        Collections.sort(arr);
        int mindiff=Integer.MAX_VALUE;
        for(int i=0;i<arr.size()-1;i++){
            mindiff=Math.min(arr.get(i+1)-arr.get(i),mindiff);
        }return mindiff;
    }
    public static void dfs(TreeNode root,ArrayList<Integer> arr){
        if(root==null) return;
        arr.add(root.val);
        dfs(root.right,arr);
        dfs(root.left,arr);
    }
}