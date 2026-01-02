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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        int sum=0;
        dfs(root,ans,new ArrayList<>(),sum,targetSum); 
        return ans; 
    }
    public static void dfs(TreeNode root,List<List<Integer>> ans,List<Integer> arr,int sum,int target){
        if(root==null) return;
        if(root.right==null && root.left==null){
            if(root.val+sum==target){
                arr.add(root.val);
                ans.add(new ArrayList<>(arr));
                arr.remove(arr.size()-1);
                return;
            }else return;
        }arr.add(root.val);
        dfs(root.left,ans,arr,sum+root.val,target);
        dfs(root.right,ans,arr,sum+root.val,target);
        arr.remove(arr.size()-1);

    }
}